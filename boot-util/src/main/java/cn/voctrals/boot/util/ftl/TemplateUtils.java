package cn.voctrals.boot.util.ftl;

import freemarker.template.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;

/**
 * Created by liulei on 02/03/2017.
 */
public class TemplateUtils {

    private static Configuration cfg;

    static {
        cfg = new Configuration(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setClassForTemplateLoading(TemplateUtils.class, "/ftl");
    }

    public static String getTemplate(String templateName, Object model) {
        String ret = "";
        try {
            Template template = cfg.getTemplate(templateName + ".ftl");
            ret = processTemplateIntoString(template, model);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String processTemplateIntoString(Template template, Object model) throws IOException, TemplateException {
        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }
}
