1. Trong quá trình tạo dự án Spring Boot chúng ta phải khai báo những tham số sau đây : groupID, artifactID. Ý nghĩa các tham số này là gì?

- groupID: Id của nhóm dự án, thường được viết theo dạng tên miền đảo ngược
- artifactID: Id của dự án

2. Tại sao phải đảo ngược tên miền trong <groupId>vn.techmaster</groupId>?

- GroupId nên được đặt theo Java's package name rules, với tên miền được đảo ngược để tạo ra tên package độc nhất.
Chi tiết: https://docs.oracle.com/javase/specs/jls/se6/html/packages.html#7.7

3. SpringBoot có 2 cơ chế để quản lý thư viện. Hãy kể tên chúng?

- Maven và Gradle

4. File pom.xml có tác dụng gì?

- Là nơi khai báo tất cả những gì liên quan đến dự án được cấu hình qua Maven như dependency, version... 

5. Trong file pom.xml có các thẻ dependency. Ý nghĩa của chúng là gì?

- Là các thẻ khai báo thư viện cần dùng trong dự án

6. Ý nghĩa của @Controllerlà gì?

- Là Annotation dùng để thông báo cho Spring Boot đây là class được sử dụng với vai trò controller.

7. Ý nghĩa của @RequestMapping là gì? Nó có những tham số gì ngoài value?

- @RequestMapping được sử dụng để map request với class hoặc phương thức xử lý request đó.
Các tham số của Annotation này gồm: value, headers, method, produces và consumes.

8. Ý nghĩa của @RequestBody khi đặt trong hàm hứng request để làm gì?

- @RequestBody được dùng để ánh xạ HttpRequest body sang một domain object tự động.

9. Hãy trả lời khi nào thì dùng @PathVariable và khi nào nên dùng @RequestParam

@RequestParam được dùng để trích xuất dữ liệu từ request query. @PathVariable thì được dùng để trích xuất dữ liệu từ URL path.

10. Thứ tự các thành phần đường dẫn @PathVariable có thể hoán đổi được không?

- Có

11. @GetMapping khác gì so với @PostMapping?

- Annotation @GetMapping đánh dấu class hoặc method xử lý HttpRequest GET, với @PostMapping thì là POST method

12. Trong các annotation @RequestMapping, @GetMapping, @PostMapping… có tham số produces = MediaType.XXXX ý nghĩa tham số này là gì?

- Là tham số định nghĩa kiểu dữ liệu trả về 

13. Giải thích ý nghĩa của @RequestBody trong đoạn code dưới đây

@PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Message echoMessage(@RequestBody Message message){
    return message;
}

- Ánh xạ HttpRequest body sang Object message


