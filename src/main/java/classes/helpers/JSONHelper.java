package classes.helpers;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/23
 * @Time: 12:50
 * @Package: classes.helpers
 */
public class JSONHelper {
    /**
     * 将对象转换为json字符串
     * @param obj
     * @return
     */
    public static String toJson(Object obj){

        if(obj==null){
            return "";
        }
        return new Gson().toJson(obj);
    }

    /**
     * 将json字符串转换为对象
     * @param json
     * @param type
     * @return
     */
    public static Object getObjectFromJson(String json, Type type){
        return new Gson().fromJson(json, type);
    }
}

