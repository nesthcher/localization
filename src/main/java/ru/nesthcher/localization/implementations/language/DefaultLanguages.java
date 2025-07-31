package ru.nesthcher.localization.implementations.language;

import java.util.Arrays;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.nesthcher.localization.interfaces.AbstractLanguage;
import ru.nesthcher.utils.enumeration.EnumUtil;

/**
 * Перечисление стандартных языков/стран для локализации.
 */
@AllArgsConstructor
@Getter
public enum DefaultLanguages implements AbstractLanguage {
    // ============== A ==============
    AFGHANISTAN("Afghanistan", "93", "AF"),
    ALBANIA("Albania", "355", "AL"),
    ALGERIA("Algeria", "213", "DZ"),
    ANDORRA("Andorra", "376", "AD"),
    ANGOLA("Angola", "244", "AO"),
    ARMENIA("Armenia", "374", "AM"),
    AUSTRALIA("Australia", "61", "AU"),
    AUSTRIA("Austria", "43", "AT"),
    AZERBAIJAN("Azerbaijan", "994", "AZ"),

    // ============== B ==============
    BAHAMAS("Bahamas", "1242", "BS"),
    BAHRAIN("Bahrain", "973", "BH"),
    BANGLADESH("Bangladesh", "880", "BD"),
    BARBADOS("Barbados", "1246", "BB"),
    BELARUS("Belarus", "375", "BY"),
    BELGIUM("Belgium", "32", "BE"),
    BELIZE("Belize", "501", "BZ"),
    BENIN("Benin", "229", "BJ"),
    BHUTAN("Bhutan", "975", "BT"),
    BOLIVIA("Bolivia", "591", "BO"),
    BOSNIA_AND_HERZEGOVINA("Bosnia and Herzegovina", "387", "BA"),
    BOTSWANA("Botswana", "267", "BW"),
    BRAZIL("Brazil", "55", "BR"),
    BRUNEI("Brunei", "673", "BN"),
    BULGARIA("Bulgaria", "359", "BG"),
    BURKINA_FASO("Burkina Faso", "226", "BF"),
    BURUNDI("Burundi", "257", "BI"),

    // ============== C ==============
    CABO_VERDE("Cabo Verde", "238", "CV"),
    CAMBODIA("Cambodia", "855", "KH"),
    CAMEROON("Cameroon", "237", "CM"),
    CANADA("Canada", "1", "CA"),
    CENTRAL_AFRICAN_REPUBLIC("Central African Republic", "236", "CF"),
    CHAD("Chad", "235", "TD"),
    CHANNEL_ISLANDS("Channel Islands", "44", "JE"),
    CHILE("Chile", "56", "CL"),
    CHINA("China", "86", "CN"),
    COLOMBIA("Colombia", "57", "CO"),
    COMOROS("Comoros", "269", "KM"),
    CONGO("Congo", "242", "CG"),
    CONGO_DEMOCRATIC_REPUBLIC("Congo, Democratic Republic of the", "243", "CD"),
    COSTA_RICA("Costa Rica", "506", "CR"),
    CROATIA("Croatia", "385", "HR"),
    CUBA("Cuba", "53", "CU"),
    CYPRUS("Cyprus", "357", "CY"),
    CZECH_REPUBLIC("Czech Republic", "420", "CZ"),

    // ============== D ==============
    DENMARK("Denmark", "45", "DK"),
    DJIBOUTI("Djibouti", "253", "DJ"),
    DOMINICA("Dominica", "1767", "DM"),
    DOMINICAN_REPUBLIC("Dominican Republic", "1809", "DO"),

    // ============== E ==============
    ECUADOR("Ecuador", "593", "EC"),
    EGYPT("Egypt", "20", "EG"),
    EL_SALVADOR("El Salvador", "503", "SV"),
    EQUATORIAL_GUINEA("Equatorial Guinea", "240", "GQ"),
    ERITREA("Eritrea", "291", "ER"),
    ESTONIA("Estonia", "372", "EE"),
    ESWATINI("Eswatini", "268", "SZ"),
    ETHIOPIA("Ethiopia", "251", "ET"),

    // ============== F ==============
    FIJI("Fiji", "679", "FJ"),
    FINLAND("Finland", "358", "FI"),
    FRANCE("France", "33", "FR"),

    // ============== G ==============
    GABON("Gabon", "241", "GA"),
    GAMBIA("Gambia", "220", "GM"),
    GEORGIA("Georgia", "995", "GE"),
    GERMANY("Germany", "49", "DE"),
    GHANA("Ghana", "233", "GH"),
    GREECE("Greece", "30", "GR"),
    GRENADA("Grenada", "1473", "GD"),
    GUATEMALA("Guatemala", "502", "GT"),
    GUINEA("Guinea", "224", "GN"),
    GUINEA_BISSAU("Guinea-Bissau", "245", "GW"),
    GUYANA("Guyana", "592", "GY"),

    // ============== H ==============
    HAITI("Haiti", "509", "HT"),
    HONDURAS("Honduras", "504", "HN"),
    HUNGARY("Hungary", "36", "HU"),

    // ============== I ==============
    ICELAND("Iceland", "354", "IS"),
    INDIA("India", "91", "IN"),
    INDONESIA("Indonesia", "62", "ID"),
    IRAN("Iran", "98", "IR"),
    IRAQ("Iraq", "964", "IQ"),
    IRELAND("Ireland", "353", "IE"),
    ISRAEL("Israel", "972", "IL"),
    ITALY("Italy", "39", "IT"),

    // ============== J ==============
    JAMAICA("Jamaica", "1876", "JM"),
    JAPAN("Japan", "81", "JP"),
    JORDAN("Jordan", "962", "JO"),

    // ============== K ==============
    KAZAKHSTAN("Kazakhstan", "7", "KZ"),
    KENYA("Kenya", "254", "KE"),
    KIRIBATI("Kiribati", "686", "KI"),
    KOREA_NORTH("Korea, North", "850", "KP"),
    KOREA_SOUTH("Korea, South", "82", "KR"),
    KOSOVO("Kosovo", "383", "XK"),
    KUWAIT("Kuwait", "965", "KW"),
    KYRGYZSTAN("Kyrgyzstan", "996", "KG"),

    // ============== L ==============
    LAOS("Laos", "856", "LA"),
    LATVIA("Latvia", "371", "LV"),
    LEBANON("Lebanon", "961", "LB"),
    LESOTHO("Lesotho", "266", "LS"),
    LIBERIA("Liberia", "231", "LR"),
    LIBYA("Libya", "218", "LY"),
    LIECHTENSTEIN("Liechtenstein", "423", "LI"),
    LITHUANIA("Lithuania", "370", "LT"),
    LUXEMBOURG("Luxembourg", "352", "LU"),

    // ============== M ==============
    MADAGASCAR("Madagascar", "261", "MG"),
    MALAWI("Malawi", "265", "MW"),
    MALAYSIA("Malaysia", "60", "MY"),
    MALDIVES("Maldives", "960", "MV"),
    MALI("Mali", "223", "ML"),
    MALTA("Malta", "356", "MT"),
    MAROCCO("Marocco", "212", "MA"),
    MAURITANIA("Mauritania", "222", "MR"),
    MAURITIUS("Mauritius", "230", "MU"),
    MEXICO("Mexico", "52", "MX"),
    MICRONESIA("Micronesia", "691", "FM"),
    MOLDOVA("Moldova", "373", "MD"),
    MONACO("Monaco", "377", "MC"),
    MONGOLIA("Mongolia", "976", "MN"),
    MONTENEGRO("Montenegro", "382", "ME"),
    MOROCCO("Morocco", "212", "MA"),
    MOZAMBIQUE("Mozambique", "258", "MZ"),
    MYANMAR("Myanmar", "95", "MM"),

    // ============== N ==============
    NAMIBIA("Namibia", "264", "NA"),
    NAURU("Nauru", "674", "NR"),
    NEPAL("Nepal", "977", "NP"),
    NETHERLANDS("Netherlands", "31", "NL"),
    NEW_ZEALAND("New Zealand", "64", "NZ"),
    NICARAGUA("Nicaragua", "505", "NI"),
    NIGER("Niger", "227", "NE"),
    NIGERIA("Nigeria", "234", "NG"),
    NORTH_MACEDONIA("North Macedonia", "389", "MK"),
    NORWAY("Norway", "47", "NO"),
    OMAN("Oman", "968", "OM"),

    // ============== P ==============
    PAKISTAN("Pakistan", "92", "PK"),
    PALAU("Palau", "680", "PW"),
    PANAMA("Panama", "507", "PA"),
    PAPUA_NEW_GUINEA("Papua New Guinea", "675", "PG"),
    PARAGUAY("Paraguay", "595", "PY"),
    PERU("Peru", "51", "PE"),
    PHILIPPINES("Philippines", "63", "PH"),
    POLAND("Poland", "48", "PL"),
    PORTUGAL("Portugal", "351", "PT"),
    QATAR("Qatar", "974", "QA"),

    // ============== R ==============
    ROMANIA("Romania", "40", "RO"),
    RUSSIA("Russia", "7", "RU"),
    RWANDA("Rwanda", "250", "RW"),

    // ============== S ==============
    SAINT_KITTS_AND_NEVIS("Saint Kitts and Nevis", "1869", "KN"),
    SAINT_LUCIA("Saint Lucia", "1758", "LC"),
    SAINT_VINCENT_AND_THE_GRENADINES("Saint Vincent and the Grenadines", "1784", "VC"),
    SAMOA("Samoa", "685", "WS"),
    SAN_MARINO("San Marino", "378", "SM"),
    SAO_TOME_AND_PRINCIPE("Sao Tome and Principe", "239", "ST"),
    SAUDI_ARABIA("Saudi Arabia", "966", "SA"),
    SENEGAL("Senegal", "221", "SN"),
    SERBIA("Serbia", "381", "RS"),
    SEYCHELLES("Seychelles", "248", "SC"),
    SIERRA_LEONE("Sierra Leone", "232", "SL"),
    SINGAPORE("Singapore", "65", "SG"),
    SLOVAKIA("Slovakia", "421", "SK"),
    SLOVENIA("Slovenia", "386", "SI"),
    SOLOMON_ISLANDS("Solomon Islands", "677", "SB"),
    SOMALIA("Somalia", "252", "SO"),
    SOUTH_AFRICA("South Africa", "27", "ZA"),
    SOUTH_SUDAN("South Sudan", "211", "SS"),
    SPAIN("Spain", "34", "ES"),
    SRI_LANKA("Sri Lanka", "94", "LK"),
    SUDAN("Sudan", "249", "SD"),
    SURINAME("Suriname", "597", "SR"),
    SWEDEN("Sweden", "46", "SE"),
    SWITZERLAND("Switzerland", "41", "CH"),
    SYRIA("Syria", "963", "SY"),

    // ============== T ==============
    TAIWAN("Taiwan", "886", "TW"),
    TAJIKISTAN("Tajikistan", "992", "TJ"),
    TANZANIA("Tanzania", "255", "TZ"),
    THAILAND("Thailand", "66", "TH"),
    TOGO("Togo", "228", "TG"),
    TONGA("Tonga", "676", "TO"),
    TRINIDAD_AND_TOBAGO("Trinidad and Tobago", "1868", "TT"),
    TUNISIA("Tunisia", "216", "TN"),
    TURKMENISTAN("Turkmenistan", "993", "TM"),
    TURKEY("Turkey", "90", "TR"),

    // ============== U ==============
    UGANDA("Uganda", "256", "UG"),
    UKRAINE("Ukraine", "380", "UA"),
    UNITED_ARAB_EMIRATES("United Arab Emirates", "971", "AE"),
    UNITED_KINGDOM("United Kingdom", "44", "GB"),
    UNITED_STATES("United States", "1", "US"),
    URUGUAY("Uruguay", "598", "UY"),
    UZBEKISTAN("Uzbekistan", "998", "UZ"),

    // ============== V ==============
    VANUATU("Vanuatu", "678", "VU"),
    VATICAN_CITY("Vatican City", "39", "VA"),
    VENEZUELA("Venezuela", "58", "VE"),
    VIETNAM("Vietnam", "84", "VN"),

    // ============== Y ==============
    YEMEN("Yemen", "967", "YE"),

    // ============== Z ==============
    ZAMBIA("Zambia", "260", "ZM"),
    ZIMBABWE("Zimbabwe", "263", "ZW");

    /**
     * Название страны/языка.
     */
    private final String name;
    /**
     * Телефонный код страны.
     */
    private final String countryCode;
    /**
     * ISO-код страны.
     */
    private final String isoCode;

    /**
     * Получить язык по ISO-коду.
     * @param isoCode ISO-код
     * @return язык или null
     */
    public static @Nullable DefaultLanguages getLangByIsoCode(
            @NotNull String isoCode
    ) {
        return Arrays.stream(DefaultLanguages.values()).filter(s -> Objects.equals(s.isoCode, isoCode)).findFirst().orElse(null);
    }

    /**
     * Получить язык по имени.
     * @param name имя
     * @return язык или null
     */
    public static @Nullable DefaultLanguages getByName(
            @NotNull String name
    ) {
        return EnumUtil.getType(DefaultLanguages.class, name, null);
    }
}