package mg.esakafo.taas.service.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate{
    public static String date(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }
}
