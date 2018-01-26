package login.domain.request;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 17:07$
 * @description:
 */
@Data
public class LoginRequest implements Validate,Serializable {
    String userId;
    Long eventTime;
    Double longitude;
    Double latitude;

    @Override
    public Boolean validate() {
        return null;
    }
}
