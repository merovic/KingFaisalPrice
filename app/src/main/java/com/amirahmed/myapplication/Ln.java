package com.amirahmed.myapplication;

public class Ln {
    
    private Boolean isRTLLanguage;

    Ln(Boolean isRTLLanguage) {
        this.isRTLLanguage = isRTLLanguage;
    }

    String getIntroductionWord() {
        return isRTLLanguage ? "المقدمة" : "introduction";
    }

    public String getKhaledword() {
        return isRTLLanguage ? "كلمة الأمير خالد الفيصل" : "In The Words of Prince Khalid Alfaisal";
    }

    public String getKhaledlink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/ar_Prince-Khalid/" : "https://www.kingfaisalappstore.org/about/en_Prince-Khalid";
    }

    public String getAngayza() {
        return isRTLLanguage ? "عن الجائزة" : "About KFP";
    }

    public String getNabza() {
        return isRTLLanguage ? "نبذة مختصرة" : "Summary";

    }

    public String getEnshaa() {
        return isRTLLanguage ? "إنشاء الجائزة" : "Establishment";
    }

    public String getAhdaf() {
        return isRTLLanguage ? "أهداف الجائزة" : "Objectives";
    }

    public String getAmana() {
        return isRTLLanguage ? "الأمانة العامة" : "General Secretariat";
    }

    public String getTare5() {
        return isRTLLanguage ? "تاريخ الجائزة" : "KFP History";
    }

    public String getMokawnat() {
        return isRTLLanguage ? "مكونات الجائزة" : "Prize Components";
    }

    public String getHay2a() {
        return isRTLLanguage ? "هيئة الجائزة" : "KFP Committee";
    }

    public String getMas2olen() {
        return isRTLLanguage ? "المسؤولون عن الجائزة" : "KFP Management";
    }

    public String getNabzaLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/arSummary" : "https://www.kingfaisalappstore.org/about/enSummary";
    }

    public String getEnshaaLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/arEstablishment" : "https://www.kingfaisalappstore.org/about/enEstablishment";
    }

    public String getAhdafLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/arObjectives" : "https://www.kingfaisalappstore.org/about/enObjectives";
    }

    public String getAmanaLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/arGeneral-Secretariat" : "https://www.kingfaisalappstore.org/about/enGeneral-Secretariat";
    }

    public String getTare5Link() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/arHistory" : "https://www.kingfaisalappstore.org/about/enHistory";
    }

    public String getMokawnatLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/arComponents" : "https://www.kingfaisalappstore.org/about/enComponents";
    }

    public String getHay2aLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/about/arCommittee" : "https://www.kingfaisalappstore.org/about/enCommittee";
    }

    public String getMas2olenLink() {
        return isRTLLanguage ? "https://online.fliphtml5.com/miyqo/nhln/" : "https://online.fliphtml5.com/miyqo/dgde/";
    }

    public String getCategories() {
        return isRTLLanguage ? "فروع الجائزة" : "Prize Categories";
    }

    public String getEslam() {
        return isRTLLanguage ? "خدمة الإسلام" : "Service to Islam";
    }

    public String getArabic() {
        return isRTLLanguage ? "اللغة العربية والأدب" : "Arabic Language and Literature";
    }

    public String getStudies() {
        return isRTLLanguage ? "الدراسات الإسلامية" : "Islamic Studies";
    }

    public String getMedical() {
        return isRTLLanguage ? "الطب" : "Medicine";
    }

    public String getScience() {
        return isRTLLanguage ? "العلوم" : "Science";
    }

    public String getEslamLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Categories/arService_Islam" : "https://www.kingfaisalappstore.org/Categories/enService_Islam";
    }

    public String getArabicLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Categories/arArabic_Literature" : "https://www.kingfaisalappstore.org/Categories/arArabic_Literature";
    }

    public String getStudiesLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Categories/arIslamicStudies" : "https://www.kingfaisalappstore.org/Categories/enIslamicStudies";
    }

    public String getMedicalLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Categories/arMedicine" : "https://www.kingfaisalappstore.org/Categories/enMedicine";
    }

    public String getScienceLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Categories/arScience" : "https://www.kingfaisalappstore.org/Categories/enScience";
    }

    public String getNomination() {
        return isRTLLanguage ? "الترشيح للجائزة" : "Nominations";
    }

    public String getNominationScience() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Nominations/ar_science" : "https://www.kingfaisalappstore.org/Nominations/en_science";
    }

    public String getNominationEslam() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Nominations/ar_service" : "https://www.kingfaisalappstore.org/Nominations/en_service";
    }

    public String getNominationStudies() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Nominations/ar_studies" : "https://www.kingfaisalappstore.org/Nominations/en_studie";
    }

    public String getNominationArabic() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Nominations/ar_arabic" : "https://www.kingfaisalappstore.org/Nominations/en_arabic";
    }

    public String getNominationMedical() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/Nominations/ar_medicine" : "https://www.kingfaisalappstore.org/Nominations/en_medicine";
    }

    public String getWinners() {
        return isRTLLanguage ? "الفائزون بالجائزه" : "Winners";
    }

    public String getEnter() {
        return isRTLLanguage ? "دخول" : "Enter";
    }

    public String getTitle() {
        return isRTLLanguage ? "الرئيسية" : "Main";
    }

    public String getSearch() {
        return isRTLLanguage ? "بحث اسم الفائز" : "Search Winner";
    }

    public String getContactus() {
        return isRTLLanguage ? "تواصل معنا" : "Contact Us";
    }

    public String getContactusLink() {
        return isRTLLanguage ? "https://www.kingfaisalappstore.org/ar_contactUs" : "https://www.kingfaisalappstore.org/en_contactUs";
    }

    public String getChoose() {
        return isRTLLanguage ? "اختر فائز أولا" : "Choose Winner First";
    }


}
