package testing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
class TextSample {
    private String text;
    private List<String> expectedResult;
}
