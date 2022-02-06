//package io.jobsearchapp;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.stream.Stream;

//@Converter(autoApply = true)
//public class SiteNameConverter implements AttributeConverter<SiteName, String> {
// 
//    @Override
//    public String convertToDatabaseColumn(SiteName siteName) {
//        if (siteName == null) {
//            return null;
//        }
//        return siteName.toString();
//    }
//
//    @Override
//    public SiteName convertToEntityAttribute(String siteName) {
//        if (siteName == null) {
//            return null;
//        }
//
//        return Stream.of(SiteName.values())
//          .filter(c -> c.toString().equals(siteName))
//          .findFirst()
//          .orElseThrow(IllegalArgumentException::new);
//    }
//}
