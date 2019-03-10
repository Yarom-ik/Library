//package by.yarom.library.Controller;
//
//
//import by.yarom.library.Entity.CatalogBooks;
//import by.yarom.library.Entity.Users;
//import by.yarom.library.Service.CatalogBooksService;
//import by.yarom.library.Service.RoleService;
//import by.yarom.library.Service.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@Controller
//public class MainController {
//
////    @Autowired
////    private CatalogBooksService catalogBooksService;
//
////    @Autowired
////    private UsersService usersService;
////
////    @Autowired
////    private RoleService roleService;
////
////
////
////    @GetMapping("/")
////    public String view(){
////        return "redirect:/books";
////    }
////
////    @GetMapping ("/edit")
////    public String editBook(@RequestParam("id") int id, Model model){
////        System.out.println(id);
////        model.addAttribute("book", this.catalogBooksService.getBookById(id));
////        return "/edit";
////    }
////
////    @GetMapping("/del")
////    public String deleteBook(@RequestParam("id") int id){
////        System.out.println(id);
////        this.catalogBooksService.deleteBook(id);
////        return "redirect:/users";
////    }
//
////    @GetMapping("/check")
////    public String cancelUpdateUser(@RequestParam("action") String action, Model model) {
////
////        model.addAttribute("book", new CatalogBooks());
////        model.addAttribute("books", catalogBooksService.getBookById(2));
////        System.out.println("DDDD"+ action);
////        return "redirect:/bo";
////    }
//
//
//
////    @GetMapping("/books")
////    //@PreAuthorize("hasRole('yarom')")
////    public String getUsers(Model model, @AuthenticationPrincipal Users users) {
////        model.addAttribute("book", new CatalogBooks());
////        model.addAttribute("books", catalogBooksService.listCatalogBook());
////        model.addAttribute("auth",users.getLogin());
////        model.addAttribute("role",users.getRole().getName());
////
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////
////        System.out.println("detail "+ auth);
////        return "books";
////    }
//
////    @PostMapping
////    public String addBook(@RequestParam ("name") String name,
////                           @RequestParam ("year") int year,
////                           @RequestParam ("invNum") int invNum,
////                           @RequestParam ("countBook") int count,
////                           @RequestParam ("NameAuthor") String nameAuthor) {
////
//////        Author author = new Author();
//////        author.setName(nameAuthor);
//////        authorService.addAuthor(author);
////        CatalogBooks catalogBooks = new CatalogBooks();
////        catalogBooks.setName(name);
////        catalogBooks.setYear(year);
////        catalogBooks.setInvNum(invNum);
////        catalogBooks.setCountBook(count);
////        //catalogBooks.setAuthor(author);
////        catalogBooksService.addCatalogBook(catalogBooks);
////        return "redirect:/users";
////    }
//
////    @PostMapping("/add")
////    public String addBooks(@ModelAttribute CatalogBooks catalogBooks){
////        catalogBooksService.addCatalogBook(catalogBooks);
////
////        return "redirect:/";
////    }
//
//}
