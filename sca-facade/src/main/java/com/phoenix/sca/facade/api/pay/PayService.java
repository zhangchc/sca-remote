package com.phoenix.sca.facade.api.pay;

import com.phoenix.sca.facade.api.pay.dto.PayResponse;

public interface PayService {

    PayResponse rePay();
    String refound();
}
