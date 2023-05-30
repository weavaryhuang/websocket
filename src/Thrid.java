import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

abstract class Thrid {
    LocalDateTime dateObj = LocalDateTime.now();
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("yyMMddHHmmss");

    public String username = "HEN";
    public String userBasicInfo = "L";
    public String currentTime = dateObj.format(formatTime);

    public abstract byte checkid();
}
