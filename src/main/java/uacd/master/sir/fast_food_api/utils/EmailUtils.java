package uacd.master.sir.fast_food_api.utils;

public class EmailUtils {

    public static String getEmailMessage(String name, String host, String token){
        return "Hello " + name +"\n\n Your new acount has created. Please click the link to verify account. \n\n" +
                getVerifiactionUrl(host, token) + "\n\nThe support Team";
    }

    public static String getVerifiactionUrl(String host, String token) {
        return host +  "/api/utilisateur?token="+token;
    }
}
