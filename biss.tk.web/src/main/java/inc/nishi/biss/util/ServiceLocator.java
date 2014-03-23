package inc.nishi.biss.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public class ServiceLocator implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ServiceLocator.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return ServiceLocator.applicationContext;
    }

    @SuppressWarnings(GlobalConstants.UNCHECKED)
    public <T extends Object> T getBean(String beanName) {
        return (T) this.getApplicationContext().getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        Map<String, T> beans = ServiceLocator.applicationContext.getBeansOfType(clazz);
        if(beans.size() == 1) {
            return beans.get(clazz.getSimpleName());
        } else {
            throw new IllegalArgumentException("More than one beans or no beans of given type are available.");
        }
    }

}
