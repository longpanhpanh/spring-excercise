1. Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế
nào? Hãy giải thích rõ cần thì minh hoạ

- Cả 2 đều là thuộc tính tùy chọn và không bắt buộc, thuộc tính name trong @Entity khi không được khai báo, 
Hibernate sẽ tạo một bảng với tên bảng là tên Class được đánh dấu @Entity. Trường hợp bạn khai báo name, name đó sẽ chỉ được dùng trong query đối với với Java Entity.
- @Table là annotation không bắt buộc, khi khai báo @Table(name = "something") bảng sẽ được tạo với tên đã được khai báo, name này sẽ hiển thị ở CSDL cũng như sử dụng trong query của Native Query.
 

VD: 
@Entity(name="something")
@Table(name="somethingElse")
class MyClass {

}

Ví dụ trên sẽ có Entity name là something và table name là somethingElse

2. Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung
lệnh nào vào file application.properties?

spring.jpa.show-sql=true : hiển thị các lệnh sql của hibernate
spring.jpa.properties.hibernate.format_sql=true : format các lệnh được hiển thị

3. Khi sử dụng H2, làm thế nào để xem được cơ sở dữ liệu và viết câu truy vấn?

Thêm vào application.properties các config sau:

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

- Enable H2 console: spring.h2.console.enabled=true

- Sau đó chúng ta có thể kết nối với giao diện của H2 Database qua h2-console với username mặc định là sa và không có password. Ở đó chúng ta có thể thực hiện xem và thực hiện truy vấn dữ liệu.

4. Khi viết mô tả một model, những thuộc tính chúng ta không muốn lưu xuống CSDL thì cần
đánh dấu bằng annotation nào?

@Transient

5. Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính. Tham số
nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính, tham số nào chỉ định
yêu cầu duy nhất, không được trùng lặp dữ liệu, tham số nào buộc trường không được null?

- Đổi lại tên column: name
- Duy nhất, không trùng lặp: unique=true
- Không được null: nullable=false

6. Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung
o Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT)
o Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE)
Vậy 2 annotation này là gì

@PrePersist và @PreUpdate 

7. Tổ hợp các trường thông tin địa chỉ: country, city, county, addressline thường luôn đi cùng
nhau và sử dụng lại trong các Entity khác nhau. Nhóm 2 annotation nào dùng để tái sử dụng,
nhúng một Entity vào một Entity khác?

- @Embeddable dùng để đánh dấu cấu trúc chung
- @Embedded để đánh dấu những bảng sử dụng cấu trúc chung

8. JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận
tiện cho thao tác dữ liệu. Cụ thể JpaRepository kế thừa từ interface nào?

- JpaRepository kế thừa từ các interface sau: CrudRepository<T,ID>, PagingAndSortingRepository<T,ID>, QueryByExampleExecutor<T>, Repository<T,ID>

9. Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu
trường Identity là long, tuân thủ interface JpaRepository.

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

10. Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique
dùng annotation @Column(unique=true) không?

- Không cần thiết vì @Id sẽ đánh dấu thuộc tính đó là primary key khi tạo bảng và mặc định primary key luôn là unique.

11. Khác biệt giữa @Id với @NaturalId là gì?

- @Id đánh dấu property sẽ là primary key.
- @NaturalId tạo unique constraint cho thuộc tính KHÔNG PHẢI primary key.

12. Có những cột không phải primary key (@Id) hay @NaturalId, dữ liệu có thể trùng lặp
(unique không đảm bảo true), nhưng cần đánh chỉ mục (index) để tìm kiếm nhanh hơn vậy
phải dùng annotation gì? Hãy viết 1 ví dụ sử dụng annotation đó với index cho 1 column và 1
ví dụ với index cho tổ hợp nhiều column. Tham khảo tại (https://www.baeldung.com/jpaindexes)

- Để đánh index cho một field có thể sử dụng annotation @Index (trong @Table).

Ví dụ: 
Single column @Index:

@Entity
@Table(indexes = @Index(columnList = "firstName"))
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    // getters, setters
}

Multi column @Index:

- Có thể đánh index cho nhiều cột, cách nhau bởi dấu ","

@Entity
@Table(indexes = @Index(columnList = "firstName, lastName"))
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    // getters, setters
}

13. Annotation @GeneratedValue dùng để chọn cách tự sinh unique id cho primary key phải là
trường kiểu int hoặc long. Nếu trường primary key có kiểu là String, chúng ta không thể
dùng @GeneratedValue vậy hãy thử liệt kê các cách đảm bảo sinh ra chuỗi có tính duy nhất?

Một số cách tạo ra chuỗi có tính duy nhất:

- UUID (vẫn có khả năng trùng, tuy rất nhỏ).
- Tạo chuỗi dựa trên một dải đếm tăng dần (giống với PKEY kiểu Long hoặc int) và chuyển thành kiểu string tùy theo thuật toán sử dụng, ví dụ có thể hash với base64(em chưa thử bao giờ nên không biêt thể trùng không :D)
- Tạo chuỗi dựa trên thời gian ví dụ 2022 06 02 20 40 39 (năm, tháng, ngày, giờ, phút, giây)


14. Giả sử có 1 class Employee với các fields sau {id, emailAddress, firstName, lastName}. Hãy
viết các method trong interface EmployeeRespository để :
o Tìm tất cả các Employee theo emailAddress và lastName
o Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
o Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
o Tìm tất cả các Employee theo fistName không phân biệt hoa thường

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmailAddressAndFirstName(String emailAddress, String firstName);

    List<Employee> findDistinctByFirstNameOrLastName(String firstName, String lastName);

    List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);

    List<Employee> findByFirstNameLike(String firstName);
}

15. Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ 

@NamedQuery có thể được sử dụng khi bạn có các câu truy vấn dùng chung và nhiều nơi, để sử dụng ta đặt annotation @NamedQuery vào class được khai báo @Entity

Ví dụ: 

@Entity
@Table(name = "customer")
@NamedQuery(name = "Customer.FIND_BY_NAME", query = "SELECT c FROM Customer c WHERE c.name like :name") })
public class Customer {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "address")
  private String address;
  
  // getter - setter
}

16. Làm thế nào để có thể viết custom method implemetations cho Jpa Repository. Nêu ví dụ

- Có thể để interface repository kế thừa JpaRepository và một custom interface (được tạo ra để viết các custom method). Sau đó viết class implementation cho interface này.

Ví dụ: 

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {
    
}

public interface EmployeeRepositoryCustom {
	Set<Employee> groupEmployeeByFirstName();
}

public class EmployeRepositoryImpl implements EmployeRepositoryCustom {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Map<String, List<Employee>> groupEmployeeByFirstname() {
        return employeeRepository
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getFirstName, HashMap::new, Collectors.toList()));
    }
}

17. Hãy nêu 1 ví dụ sử dụng sorting và paging khi query đối tượng Employee ở trên
- Vì kế thừa interface JpaRepository (interface này kế thừa PagingAndSortingRepository) nên chúng ta có 2 method findAll(Pageable pageable) và findAll(Sort sort) dùng cho paginating và sorting

// sort by lastName 
List<Employee> sortingByLastName =  employeeRepository.findAll(Sort.by("lastName"));

// lấy page đầu với 3 đối tượng
List<Employee> paging = employeeRepository.findAll(PageRequest.of(0, 3)).toList();

18. Có 3 Entity Product.java và Category.java và Tag.java
• Hãy bổ sung định nghĩa quan hệ One to Many giữa bảng Category (One) -- Product
(Many). Chú ý khi một Category xoá, thì không được phép xoá Product, mà chỉ set
thuộc tính Category của Product là null.
• Hãy bổ sung định nghĩa quan hệ Many to Many giữa bảng Tag(Many) --
Product(Many).

Category

@Entity(name="category")
@Table(name="category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "category", orphanRemoval = false)
    private Set<Product> products;
}

Product

@Entity(name="product")
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private Set<Tag> tags;
}

Tag

@Entity(name="tag")
@Table(name="tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
}







