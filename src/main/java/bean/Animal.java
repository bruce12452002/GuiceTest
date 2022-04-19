package bean;

import com.google.inject.ImplementedBy;
import com.google.inject.ProvidedBy;
import provider.MyProvider;

//@ProvidedBy(MyProvider.class)
@ImplementedBy(Ox.class)
public interface Animal {
}
