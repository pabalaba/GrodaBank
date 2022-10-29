package chr.ptr.main.logs;

import chr.ptr.main.Main;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GBLogger {

    public static String file = "";

    public static void writeLogPay(BigDecimal amount, String receiver, String sender){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        write("["+formatter.format(date)+"]Action: PAY, Receiver: "+receiver+", Sender: "+sender+", Amount: "+ amount.toString()+"\n");
    }

    public static void writeLogSet(BigDecimal amount, String receiver, String sender){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        write("["+formatter.format(date)+"]Action: SET, Receiver: "+receiver+", Sender: "+sender+", Amount: "+ amount.toString()+"\n");
    }

    public static void write(String message){
        try {

            Files.write(Paths.get(file), message.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileName(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        file = Main.getPlugin(Main.class).logPath+"\\"+formatter.format(date)+"log.txt";
        try{
            File yourFile = new File(file);
            yourFile.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
