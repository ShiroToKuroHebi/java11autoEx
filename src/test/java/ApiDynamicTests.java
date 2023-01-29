import api_objects.ResultDto;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Utils.objMapper;

public class ApiDynamicTests {
    protected static ArrayList<String> data = new ArrayList<>();
    private static final String URL = "https://api.nationalize.io";
    private final Logger log = Logger.getLogger("ApiDynamicTests");

    @BeforeAll
    public static void init() {
        for (int i = 5; i < 10; i++) {
            data.add(Utils.getAlphaStr(i));
        }
        data.add("Alex");
    }

    @TestFactory
    public List<DynamicTest> stringNationality() {
        List<DynamicTest> tests2Run = new ArrayList<>();
        for (String str: data) {
            tests2Run.add(
                DynamicTest.dynamicTest(
                    "Get nationality for " + str,
                    () -> {
                        RequestSpecification rs = given().param("name", str);
                        Response response = rs.get(URL);
                        response.then().assertThat().statusCode(200);
                        String body = response.getBody().asString();
                        log.info(body);
                        ResultDto resultDto = objMapper.readValue(body, ResultDto.class);

                        assertEquals(str, resultDto.getName());
                        if (null != resultDto.getCountryList()) {
                            assertThat("Returned country list is empty!", !resultDto.getCountryList().isEmpty());
                        }
                    }
                )
            );
        }
        return tests2Run;
    }
}
