package platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({
        "code",
        "date",
})
public class CodeContext {

    @Id
    @JsonIgnore
    private String id;

    @JsonProperty("code")
    private String userCode;

    private Long time;

    private Long views;

    private LocalDateTime date;

    @JsonProperty("date")
    public String getDateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    @JsonIgnore
    private Instant start = Instant.now();
    @JsonIgnore
    private boolean restrictionsOnTime;
    @JsonIgnore
    private boolean restrictionsOnViews;


    @JsonIgnore
    public Long getSecondsOfExist() {
        Duration d = Duration.between(start, Instant.now());
        return d.toSeconds();
    }




    public void setIdUUID() {
        this.id = UUID.randomUUID().toString();
    }
}