package component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.inject.Specializes;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.DateConverter;

@Specializes
@Convert(Date.class)  
@SuppressWarnings("deprecation")
public class CustomDateConverter extends DateConverter {  

    @Override
    public Date convert(String value, Class<? extends Date> type) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value);
        } catch (ParseException e) {
            return null;
        }
    }  
}
