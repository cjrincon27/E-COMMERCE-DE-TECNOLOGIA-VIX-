package ChallengeFinal.service;

public interface EmailService {

    //Este metodo para enviar mail, textMessage string que contiene el mail, email el mail que lo recibe, subject es el asunto del mail
    public boolean sendEmailTool(String textMessage, String email, String subject);
}
