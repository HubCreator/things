package thigns.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Provider;


@Component
@Scope("singleton")
public class Single {
    @Autowired
    private Provider<Proto> objectProvider;

    public int logic() {
        Proto proto = objectProvider.get();
        proto.add();
        return proto.getCount();
    }
}
