import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils  {
    private static ApplicationContext context;

    public ApplicationContextUtils(ApplicationContext context) {
        this.context = context;
    }

    public static <T extends Object> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

}
