package by.yarom.library.Controller;

import by.yarom.library.Entity.*;
import by.yarom.library.Service.*;
import by.yarom.library.backetBook.BasketBook;
import by.yarom.library.validator.BookValidator;
import by.yarom.library.validator.ReaderValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.*;

@Controller
@Scope("request")
@PreAuthorize("hasAuthority('admin') or hasAuthority('library')")
public class LibraryController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private CatalogBooksService catalogBooksService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BasketBook basketBook;

    @Autowired
    private GiveService giveService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UsersService usersService;

    @Autowired
    @Qualifier("bookValidator")
    private BookValidator bookValidator;

    @Autowired
    @Qualifier("readerValidator")
    private ReaderValidator readerValidator;

    final static Logger logger = Logger.getLogger(LibraryController.class);

    @RequestMapping ("/statistic")
    public String statistic(@RequestParam(value = "date", required = false) String date,
                            Model model) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int startYear = 2017;
        int yearNow = calendar.get(Calendar.YEAR);
        int[] years = new int[(yearNow-startYear)];
        for (int i = 0; i<=(yearNow-startYear);i++){
            years[i]=startYear+=1;
        }
        if (date==null){

            model.addAttribute("mountCount", giveService.giveStatistic(yearNow));
            model.addAttribute("yearNow", yearNow);
        }else {
            model.addAttribute("mountCount", giveService.giveStatistic(Integer.parseInt(date)));
            model.addAttribute("yearNow", Integer.parseInt(date));
        }
        model.addAttribute("years",years);
        return "/statistic";
    }

    @PreAuthorize("hasAuthority('reader') or hasAuthority('library') or hasAuthority('admin')")
    @PostMapping(value = "/editPassword")
    public String editPassword(@ModelAttribute ("password") String password,
                               @ModelAttribute ("passwordNew") String passwordNew,
                               @ModelAttribute ("login") String login,
                               @AuthenticationPrincipal Users user,
                               Model model){
        Users users = usersService.getUserByLogin(login);
        if (!password.equals(users.getPassword())) {
            model.addAttribute("errorVerificatePass",true);
            model.addAttribute("password",password);
            model.addAttribute("passwordNew",passwordNew);
        }else {
            users.setPassword(passwordNew);
            usersService.updateUser(users);
            model.addAttribute("editPasswordOkk", true);
        }
        model.addAttribute("userAccount", usersService.getUserByLogin(user.getLogin()));
        return "/account";
    }

    @RequestMapping("/deleteReader/{id}")
    public String deleteReader(@PathVariable (value = "id") int idReader) {
        Reader reader = readerService.getReaderById(idReader);
        reader.setActive(false);
        readerService.updateReader(reader);
        return "redirect:/readers";
    }

    @RequestMapping(value = "/readerAdd", method = RequestMethod.POST)
    public String readerAddNew(@ModelAttribute @Valid Reader reader,
                                BindingResult bindingResult,
                                Model model){
        readerValidator.validate(reader,bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            errorsMap.putAll(ControllerUtils.getErrors(bindingResult));
            model.mergeAttributes(errorsMap);
        }else {
            reader.setActive(true);
            readerService.addReader(reader);
            model.addAttribute("addOk", true);
        }
        model.addAttribute("readerNew", reader);
        listBasket(model);
        return "/readerAdd";
    }

    @RequestMapping(value = "/readerAdd")
    public String readerAdd(Model model){
        listBasket(model);
        return "/readerAdd";
    }

    @RequestMapping(value = "/categoryes/edit", method = RequestMethod.GET)
    public String categoryEdit(@ModelAttribute @Valid Category category,
                               BindingResult bindingResult,
                               Model model){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            errorsMap.putAll(ControllerUtils.getErrors(bindingResult));
            model.mergeAttributes(errorsMap);
            model.addAttribute("categoryes", categoryService.categoryList());
            return "/categoryes";
        }else {
            categoryService.editCategory(category);
        }
        return "redirect:/categoryes";
    }

    @RequestMapping(value = "/categoryes/add", method = RequestMethod.POST)
    public String categoryAdd(@ModelAttribute @Valid Category category,
                              BindingResult bindingResult,
                              Model model){
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            errorsMap.putAll(ControllerUtils.getErrors(bindingResult));
            model.mergeAttributes(errorsMap);
            model.addAttribute("categoryes", categoryService.categoryList());
            return "/categoryes";
        }else {
            categoryService.addCategory(category);
        }
        return "redirect:/categoryes";
    }

    @RequestMapping("/categoryes/delete")
    public String categoryDelete(@ModelAttribute Category category){
        System.out.println(category);
        categoryService.deleteCategory(category);
        return "redirect:/categoryes";
    }

    @RequestMapping("/categoryes")
    public String categoryes(@ModelAttribute Category category,
                             Model model){
        listBasket(model);
        model.addAttribute("categoryes", categoryService.categoryList());
        return "/categoryes";
    }

    @GetMapping("/readerEdit")
    public String readerEdit(@ModelAttribute Reader reader){
        Reader readerOld = readerService.getReaderById(reader.getIdReader());
        readerOld.setActive(true);
        readerOld.setFirstName(reader.getFirstName());
        readerOld.setMiddleName(reader.getMiddleName());
        readerOld.setLastName(reader.getLastName());
        readerOld.setTelephone(reader.getTelephone());

        readerService.updateReader(readerOld);
        return "redirect:/readerInfo/"+reader.getIdReader();
    }

    @RequestMapping("/readerInfo/{id}")
    public String readerInfo(@RequestParam(value = "action", required = false)String actionIdOrder,
                             @RequestParam(value = "returnBookId",required = false) String returnBookId,
                             @RequestParam(value = "returnBookAll",required = false) String returnBookAll,
                             @RequestParam(value = "returnBook", required = false) boolean returnBook,
                             @PathVariable(value = "id")int idReader, Model model){
        listBasket(model);
        model.addAttribute("readerId", readerService.getReaderById(idReader));
        model.addAttribute("orders", orderService.orderListByReaderId(idReader));

        if (actionIdOrder != null) {
            model.addAttribute("gives", giveService.giveListByOrderId(new Integer(actionIdOrder), idReader));
            model.addAttribute("idOrd",(new Integer(actionIdOrder)));
            model.addAttribute("orderActive", orderService.getOrderById(new Integer(actionIdOrder)).getData());
        }
        if (returnBookId != null){
            giveService.returnGive(returnBookId,returnBook,actionIdOrder, idReader);
            return "redirect:/readerInfo/"+idReader+"?action="+actionIdOrder;
        }
        if (returnBookAll != null){
            giveService.returnGiveAll(actionIdOrder,idReader);
            return "redirect:/readerInfo/"+idReader+"?action="+actionIdOrder;
        }
        return "/readerInfo";
    }

    @RequestMapping("/readers")
    public String readers(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                          @RequestParam(value = "action", required = false) String actionChar,
                          @RequestParam(value = "fio", required = false) String nameFio,
                          @RequestParam(value = "owes", required = false) boolean owes,
                          Model model){
        listBasket(model);

        if (actionChar != null){
            model.addAttribute("readers", readerService.listReaderByChar(actionChar, page));
            Long count = readerService.countFindReaderByChar(actionChar);
            model.addAttribute("count",count);
            Long pageCount = Long.valueOf(0);
            for(int itr=0;itr<count;itr+=10){
                pageCount++;
            }
            model.addAttribute("countFindReaders", pageCount);
        }
        if (nameFio != null){
            if (readerService.listReaderByName(nameFio, page) == null){
                model.addAttribute("error", true);
                return "/readers";
            }
            model.addAttribute("readers", readerService.listReaderByName(nameFio, page));
            Long count = readerService.countFindReaderByName(nameFio);
            model.addAttribute("count",count);
            Long pageCount = Long.valueOf(0);
            for(int itr=0;itr<count;itr+=10){
                pageCount++;
            }
            model.addAttribute("countFindReaders", pageCount);
        }
        if (owes){
            System.out.println("DOLZHNIKI");
            model.addAttribute("readers", readerService.listReaderByOwes(page));
            Long count = readerService.countFindReaderByOwes();
            model.addAttribute("count",count);
            Long pageCount = Long.valueOf(0);
            for(int itr=0;itr<count;itr+=10){
                pageCount++;
            }
            model.addAttribute("owes", true);
            model.addAttribute("countFindReaders", pageCount);
        }

        if (actionChar == null && nameFio == null && owes == false) {
            model.addAttribute("readers", readerService.listReader(page));
            Long count = readerService.countFindReader();
            model.addAttribute("count", count);
            Long pageCount = Long.valueOf(0);
            for (int itr = 0; itr < count; itr += 10) {
                pageCount++;
            }
            model.addAttribute("countFindReaders", pageCount);
        }
        model.addAttribute("action", actionChar);
        model.addAttribute("nameFIO",nameFio);
        model.addAttribute("activePage", page);
        return "/readers";
    }

    @RequestMapping(value = "/bookAdd", method = RequestMethod.POST)
    public String bookNew(@ModelAttribute @Valid CatalogBooks catalogBooks,
                          BindingResult bindingResult,
                          @ModelAttribute @Valid Author author,
                          BindingResult bindingResultAuthor,
                          @ModelAttribute Category category,
                          Model model){
        bookValidator.validate(catalogBooks, bindingResult);
        if (bindingResult.hasErrors() || bindingResultAuthor.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            errorsMap.putAll(ControllerUtils.getErrors(bindingResultAuthor));
            model.mergeAttributes(errorsMap);
            model.addAttribute("book", catalogBooks);
            model.addAttribute("author", author);
            model.addAttribute("category",categoryService.getCategory(category.getId_Category()));
        }else {
            Category category1 = categoryService.getCategory(category.getId_Category());
            catalogBooks.setCategory(category1);
            catalogBooks.setActive(true);
            Author authorNew = authorService.getAuthorByName(author.getAuthorName());
            if (authorNew != null){
               catalogBooks.setAuthor(authorNew);
            }else {
                authorService.addAuthor(author);
                catalogBooks.setAuthor(author);
            }
            catalogBooksService.addCatalogBook(catalogBooks);
            logger.info("book add is ok  -" + catalogBooks);
            model.addAttribute("addOk", true);
        }
        listBasket(model);
        model.addAttribute("categoryes", categoryService.categoryList());
        model.addAttribute("authors", authorService.listAuthors());

        return "/bookAdd";
    }

    @RequestMapping("bookAdd")
    public String bookAdd(Model model){
        listBasket(model);
        model.addAttribute("authors", authorService.listAuthors());
        model.addAttribute("categoryes", categoryService.categoryList());
        return "/bookAdd";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable (value = "id") int idBook){
        CatalogBooks catalogBooks = catalogBooksService.getBookById(idBook);
        catalogBooks.setActive(false);
        catalogBooksService.updateBook(catalogBooks);
        logger.info("book is deleted ok -" + catalogBooks);
        return "redirect:/books";
    }

    @PostMapping("/bookInfo/{id}")
    public String editBook(@ModelAttribute @Valid CatalogBooks catalogBooks,
                           BindingResult bindingResult,
                           @ModelAttribute @Valid Author author,
                           BindingResult bindingResultAuthor,
                           @ModelAttribute Category category,
                           Model model){

        if (bindingResult.hasErrors() || bindingResultAuthor.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            errorsMap.putAll(ControllerUtils.getErrors(bindingResultAuthor));
            model.mergeAttributes(errorsMap);
            catalogBooks.setAuthor(author);
            catalogBooks.setCategory(category);
            model.addAttribute("book", catalogBooks);
            model.addAttribute("category", categoryService.categoryList());
        }else {
            catalogBooks.setActive(true);
            Author authorNew = authorService.getAuthorByName(author.getAuthorName());
            if (authorNew != null){
                catalogBooks.setAuthor(authorNew);
            }else {
                authorService.addAuthor(author);
                catalogBooks.setAuthor(author);
            }
            catalogBooks.setCategory(categoryService.getCategoryByName(category.getCategoryName()));
            model.addAttribute("book", catalogBooks);
            catalogBooksService.updateBook(catalogBooks);
            model.addAttribute("category", categoryService.categoryList());
            logger.info("book is edit ok -" + catalogBooks);
            model.addAttribute("editOK", true);
        }
        listBasket(model);
        model.addAttribute("authors", authorService.listAuthors());
        return "/bookInfo";
    }

    @GetMapping("/bookInfo/{id}")
    public String cancelUpdateUser(@PathVariable("id") int id, Model model) {
       listBasket(model);
        model.addAttribute("book", catalogBooksService.getBookById(id));
        model.addAttribute("category",categoryService.categoryList());
        model.addAttribute("authors", authorService.listAuthors());
        return "/bookInfo";
    }

    @RequestMapping("/clearBasketId/{id}")
    public String clearBasketById(@ModelAttribute("id") int id){
        basketBook.delBasketBook(id,1);
        return "redirect:/orders";
    }

    @RequestMapping("/clearBasket")
    public String clearBasket(Model model){
        basketBook.deleteAll();
        listBasket(model);
        model.addAttribute("clear",true);
        return "/orders";
    }

    @RequestMapping("/orderPlus/{id}")
    public String orderPlus(@PathVariable ("id") int id){
        System.out.println(id);
        Iterator<Map.Entry<Integer,Integer>> iter = basketBook.getBooksBasket().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer,Integer> entry = iter.next();
            if(id == (entry.getKey())){
                int col = entry.getValue();
                col++;
                entry.setValue(col);
            }
        }
        return "redirect:/orders";
    }

    @RequestMapping("/orderMin/{id}")
    public String orderMin(@PathVariable ("id") int id){
        Iterator<Map.Entry<Integer,Integer>> iter = basketBook.getBooksBasket().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer,Integer> entry = iter.next();
            if(id == (entry.getKey())){
                int col = entry.getValue();
                if (col>1) {
                    col--;
                    entry.setValue(col);
                }
            }
        }
        return "redirect:/orders";
    }

    @RequestMapping("/orders")
    public String orders(@RequestParam(value = "actionMin", required = false)  String actionMin,
                            Model model){
        if (actionMin != null){
            System.out.println(actionMin);
        }
        listBasket(model);
        return "/orders";
    }

    public Model listBasket(Model model){
       Map<CatalogBooks, Integer> listBasket = new LinkedHashMap<>();
        Iterator<Map.Entry<Integer,Integer>> iter = basketBook.getBooksBasket().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer,Integer> entry = iter.next();
            listBasket.put( catalogBooksService.getBookById(entry.getKey()),entry.getValue());
        }
        model.addAttribute("basket", listBasket);
        model.addAttribute("count",listBasket.size());
        model.addAttribute("reader", readerService.getReaderById(basketBook.getReaderId()));
        return model;
    }

    @Transactional
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String order(Model model,
                        RedirectAttributes redirectAttributes) throws Exception{

        Reader reader = readerService.getReaderById(basketBook.getReaderId());
        Order order = new Order();
        order.setData(new Date());
        order.setFinished(false);
        order.setReader(reader);
        orderService.addOrder(order);
        CatalogBooks catalogBooks = new CatalogBooks();
        Iterator<Map.Entry<Integer,Integer>> iter = basketBook.getBooksBasket().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            catalogBooks = (catalogBooksService.getBookById(entry.getKey()));
            int count = catalogBooks.getCountBook();
            if (count > 0) {
                count = count - entry.getValue();
                if (count < 0) {
                    model.addAttribute("error", true);
                    TransactionAspectSupport.currentTransactionStatus()
                            .setRollbackOnly();
                    listBasket(model);
                    logger.debug("error order book count < 0");
                    return "/orders";
                }
                for (int i = 0; i < entry.getValue(); i++) {
                    Give give = new Give();
                    give.setOrder(order);
                    catalogBooks.setCountBook(count);
                    catalogBooksService.updateBook(catalogBooks);
                    give.setCatalogBooks(catalogBooks);
//                    give.setDataGive(new Date());
                    give.setFinished(false);
                    giveService.addGive(give);
                }
            } else {
                model.addAttribute("error", true);
                TransactionAspectSupport.currentTransactionStatus()
                        .setRollbackOnly();
                listBasket(model);
                logger.error("Ошибка выдачи книг");
                return "/orders";
            }
        }
            listBasket(model);
            basketBook.deleteAll();
            redirectAttributes.addFlashAttribute("ok",true);
        return "redirect:/orders";
    }

    @RequestMapping("/addToReader/{id}")
    public String addToReader(@ModelAttribute("id") int id,
                              HttpServletRequest request){
        if (basketBook.getReaderId() == 0){
            basketBook.setReaderId(id);
        }else {
            basketBook.deleteAll();
            basketBook.setReaderId(id);
        }
        return "redirect:" + request.getHeader("referer");
    }

    @RequestMapping("/addToOrder/{id}")
    public String addTo(@ModelAttribute("id") int id,
                        HttpServletRequest request){

        basketBook.addToBasket(id,1);
        return "redirect:" + request.getHeader("referer");
    }

    @GetMapping("/books")
    @PreAuthorize("hasAuthority('reader') or hasAuthority('library') or hasAuthority('admin')")
    public String getUsers(@RequestParam(value = "action", required = false)  String action,
                           @RequestParam(value = "find", required = false) String find,
                           @RequestParam(value = "param", required = false) String param,
                           @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,

                           Model model, @AuthenticationPrincipal Users users) {
        listBasket(model);

        if(param != null && find != null) {
            model.addAttribute("books",catalogBooksService.listBooksByParam(find, param, page));
            Long count = catalogBooksService.countFindBookByParam(find, param);
            model.addAttribute("countBooks",count);
            Long pageCount = Long.valueOf(0);
            for(int itr=0;itr<count;itr+=10){
                pageCount++;
            }
            model.addAttribute("findNameInput", find);
            model.addAttribute("paramInput", param);
            model.addAttribute("countFindBooks", pageCount);
        }
        if (action != null) {
            System.out.println(action);
            model.addAttribute("books", catalogBooksService.listBooksByChar(action, page));
            Long count = catalogBooksService.countFindBookByChar(action);
            model.addAttribute("countBooks",count);
            Long pageCount = Long.valueOf(0);
            for(int itr=0;itr<count;itr+=10){
                pageCount++;
            }
            model.addAttribute("action", action);
            model.addAttribute("countFindBooks", pageCount);

        }
        if (action == null && find == null && param == null){
            System.out.println("KOGda vse2");
            model.addAttribute("books", catalogBooksService.listCatalogBooks(page));
            Long count = catalogBooksService.countFindBook();
            model.addAttribute("countBooks",count);
            Long pageCount = Long.valueOf(0);
            for(int itr=0;itr<count;itr+=10){
                pageCount++;
            }
            model.addAttribute("countFindBooks", pageCount);
            }
        model.addAttribute("activePage",page);
        return "/books";
    }

}
