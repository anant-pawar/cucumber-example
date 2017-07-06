package com.bosch.transformers;

import com.bosch.helper.JsonHelper;
import com.bosch.model.User;
import cucumber.api.Transform;
import cucumber.api.Transformer;

/**
 * Created by Anant on 06-07-2017.
 */
public class UserTransformer extends Transformer<User> {
    @Override
    public User transform(String jsonString) {
        return JsonHelper.getInstance(jsonString, User.class);
    }
}
