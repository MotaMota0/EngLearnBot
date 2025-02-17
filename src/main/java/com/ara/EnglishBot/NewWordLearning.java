package com.ara.EnglishBot;

import com.ara.EnglishBot.serivce.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class NewWordLearning  extends TelegramLongPollingBot {
    @Value("${telegram.bot.username}")
    private String name;
    @Value("${telegram.bot.token}")
    private  String token ;

    @Autowired
    private DataService dataService;


    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){

            String chatId = update.getMessage().getChatId().toString();
            String userMessage = update.getMessage().getText();

            String response = null;
            try {

                response = processUserMessage(userMessage,chatId);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(response);

            try{
                execute(message);
            }
            catch (TelegramApiException e){
                e.printStackTrace();
            }
        }



    }

    private String processUserMessage(String userMessage,String chatId) throws TelegramApiException {
        if(userMessage.equalsIgnoreCase("/start")){
            return "Привет! Я бот для изучения английских слов для начинающих.";
        }  else if(userMessage.equalsIgnoreCase("/word")){
            return dataService.getRandomWords();
        }
        else if(userMessage.equalsIgnoreCase("/help")){
            return """
                        📌 Доступные команды:
                        /start - Запуск бота
                        /help - Список команд
                        /word - Получить случайное английское слово с переводом
                        """;
        }
        else{
            return "Err";
        }

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

   @Override
    public String getBotToken(){
        return token;
    }
    @Override
    public void onRegister() {
        super.onRegister();
    }

    /*public String getWords(){
        String [][] words = {
                {"apple", "яблоко"},
                {"book", "книга"},
                {"computer", "компьютер"},
                 {"dog", "собака"},
                {"sun", "солнце"},
                {"car", "машина"}
         };
        int rand = new Random().nextInt(words.length);

        return words[rand][0] + "  -  " +words[rand][1];
    }*/
    /*public  SendMessage hermitageInlyneKeyboardAb(long chat_id){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chat_id));
        message.setText("Choose your theme");
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton> > rowInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Kitchen");
        inlineKeyboardButton1.setCallbackData("KITCHEN");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Cake");
        inlineKeyboardButton2.setCallbackData("CAKE");

        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Sweets");
        inlineKeyboardButton3.setCallbackData("SWEETS");

        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setText("Chocolate");
        inlineKeyboardButton4.setCallbackData("CHOCOLATE");

        rowInline2.add(inlineKeyboardButton3);
        rowInline2.add(inlineKeyboardButton4);

        rowInline.add(rowInline1);
        rowInline.add(rowInline2);

        markup.setKeyboard(rowInline);

        message.setReplyMarkup(markup);


        return message;
    }*/
    /*sendTextButtonMessage(
            "Choose a theme",
            "kitchen","btn_kitchen",
            "bathroom", "btn_bathroom"
    );*/




}
