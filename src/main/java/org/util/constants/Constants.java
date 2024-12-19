package org.util.constants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Constants {

    public static List<String> MONTHS = Arrays.asList("JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEPT, OCT, NOV, DEC");
    public static Map<String, String> monthMap = Map.ofEntries(
            entry("01", "JAN"),
            entry("02", "FEB"),
            entry("03", "MAR"),
            entry("04", "APR"),
            entry("05", "MAY"),
            entry("06", "JUN"),
            entry("07", "JUL"),
            entry("08", "AUG"),
            entry("09", "SEPT"),
            entry("10", "OCT"),
            entry("11", "NOV"),
            entry("12", "DEC")
    );
    public static int ENTITY_NAME_INDEX = 2;
    public static int AMOUNT_INDEX = 4;
    public static String INCOME = "Income";
    public static List<String> INCOME_ENTITY_LIST = Arrays.asList("ELECTRONIC DEPOSIT OPTUM SERVICES");
    public static String GROCERIES = "Groceries";
    public static List<String> GROCERIES_ENTITY_LIST = Arrays.asList("CUB FOODS", "HY-VEE SHAKOPEE 1562", "WM SUPERCENTER", "DEBIT PURCHASE HY-VEE",
             "CHASKA CUB FOODS", "DILLONS", "DEBIT PURCHASE -VISA CUB FOODS", "DEBIT PURCHASE -VISA CHASKA CUB", "LUNDS&BYERLYS CHANH", "DEBIT PURCHASE CUB FOODS",
            "KOWALSKI'S MARKET", "COSTCO WHSE #0783", "DEBIT PURCHASE WM SUPERC Wal-Ma");
    public static String DINING_OUT = "Dining Out";
    public static List<String> DINING_OUT_ENTITY_LIST = Arrays.asList("DOMINO'S", "KYOTO SUSHI", "CARIBOU COFFEE", "TGI FRIDAYS", "TST* BARABELLO",
            "DD DOORDASH", "JERSEY MIKES", "TST* Nautical Bowls", "Pho 83", "FACTOR75", "DEBIT PURCHASE -VISA PHO 83", "DEBIT PURCHASE -VISA KYOTO SUSHI",
            "CULVERS", "PANDA EXPRESS", "MCDONALD'S", "CHIPOTLE", "QDOBA", "MSP AIRP AUNTIE ANNES ", "GYU KAKU", "DD *DONRAMONMEXICANR ",
            "NOODLES & CO", "BRUEGGERSMOBILEAPP", "ORDER.NOODLES.COM", "BURGERS BY BIGGS", "PHO 83", "TST* GREEK GRILL", "ASIAN BOWL",
            "DEBIT PURCHASE -VISA QDOBA", "DEBIT PURCHASE -VISA CULVERS", "TST* NAUTICAL BOWLS", "STAR WOK", "EL HUARACHE MEXICANO",
            "CKE*BO DIDDLEYS SOUP", "SQ *BUNMEE BUNTEA REST", "SQ *FRUITFUL ACAI BOWL", "MCDONALD", "CC* CRUMBL", "TST* CARIBOU COFFEE",
            "DEBIT PURCHASE -VISA SQ *SABBAI'S", "VIET HOA", "SQ *SABBAI'S THE DO", "TST* THE GREEK GRILL", "AUNTIE ANNE'S", "OLIVE GARDEN",
            "SQ *SYLAS AND MADDY'S", "LULUS LATIN FOOD LLC", "PERKINS RESTAURANT", "NAGOYA", "TST* URBAN WOK", "DAIRY QUEEN",
            "DEBIT PURCHASE -VISA SQ *BUNMEE BUNTESHAKOPEE", "SQ *CTC", "FOOD AT*", "NAF NAF GRILL", "LIONS TAP", "DOMINO", "SQ *BRUEGGER'S BAGELS",
            "SQ *NIKO NIKO BOBA", "DEBIT PURCHASE -VISA PANDA EXPRESS", "POPEYES", "DEBIT PURCHASE -VISA STAR WOK", "HELLOFRESH", "SQ *THE BURGER STAND",
            "DD *DOORDASH DIMSUMGAR", "SQ *CHRIST&LEE CORPORA", "SQ *LIVERMORE ENTERPRI", "DEBIT PURCHASE -VISA CMSVEND*CV", "BRUEGGERS");
    public static String BILLS = "Bills";
    public static List<String> BILL_ENTITY_LIST = Arrays.asList("COMCAST", "FSI*CENTERPOINT ENERGY", "SHAKOPEE UTILITIE",
            "REVO*PRAIRIEBENDHOMEOW", "SHAKOPEE PUBLIC UTILIT", "AMERICAN FAMILY MUTUAL", "ABC*Anytime Fitness",
            "WEB MORTGAGE PAYMENT", "MN DRIVER AND VEHICLE",
            "WEB AUTHORIZED PMT Prairie Bend Hom", "ABC*1905-Anytime Fitne", "ANNUAL MEMBERSHIP FEE", "WEB AUTHORIZED PMT CPENERGY MNGCO",
            "MOBILE BANKING MORTGAGE PAYMENT");
    public static String ENTERTAINMENT = "Entertainment";
    public static List<String> ENTERTAINMENT_ENTITY_LIST = Arrays.asList("FRGN TRANS FEE-COGNOSPHERE", "COGNOSPHERE", "MARCUS SOUTHBRIDGE CON",
            "CKO*Patreon", "AMC", "Patreon", "GOOGLE *Smilegate", "Steam Purchase", "DisneyPLUS", "Oculus", "Cognosphere", "HOYOVERSE", "Disney Plus",
            "HoYoverse", "FRGN TRANS FEE-HOYOVERSE", "BEST BUY", "BANDCAMP", "FRGN TRANS FEE-HoYoverse", "STEAMGAMES", "WL *Steam Purchase",
            "DEBIT PURCHASE -VISA AMC", "AMAZE* DIRT POOR ROBIN", "FRGN", "NETFLIX.COM", "MARCUS SOUTHBRIDGE", "Etsy.com", "SQ *LYUDMILLA LELYUKH");
    public static String PET = "Pet";
    public static List<String> PET_ENTITY_LIST = Arrays.asList("THE CAT'S MEOW", "CHWYIN", "PETSMART", "DEBIT PURCHASE CHUCK&DONS", "SHAKOPEE VETERINARY",
            "CHEWY", "DEBIT PURCHASE -VISA THE CAT'S MEOW GRICHFIELD", "THE CAT''S MEOW GROOMIN", "CHUCK&DONS");
    public static String MISC = "Misc";
    public static List<String> MISC_ENTITY_LIST = Arrays.asList("WAL-MART", "TARGET", "WEB AUTHORIZED PMT PAYMENT FOR AMZ", "PAYPAL", "DOLLAR GENERAL",
            "DEBIT PURCHASE -VISA TARGET", "WWW COSTCO COM", "WEB AUTHORIZED PMT AMZ_STORECRD_PMT", "CVS/PHARMACY",
            "WEB AUTHORIZED PMT AMAZON CORP", "WALGREENS", "ATM WITHDRAWAL HOLIDAY", "HY-VEE CAR WASH", "SCOTT COUNTY SHAKOPEE", "WEB AUTHORIZED PMT ACCT INTEGRATORS",
            "739 - TELEGRAPH1STEDIT NEWARK");
    public static String GAS_STATION = "Gas Station";
    public static List<String> GAS_STATION_ENTITY_LIST = Arrays.asList("HOLIDAY STATIONS", "KWIK TRIP", "KUM&GO", "KWIK SHOP",
            "SPEEDWAY", "HY-VEE F&F", "DEBIT PURCHASE -VISA HOLIDAY STATION", "SUPERAMERICA", "DEBIT PURCHASE COSTCO GAS", "COSTCO GAS",
            "SHAKOPEE DAKOTA CONV", "CASEYS");
    public static String HOME_REPAIR = "Home Repair";
    public static List<String> HOME_REPAIR_ENTITY_LIST = Arrays.asList("WEB AUTHORIZED PMT GreenSky",
            "DEBIT PURCHASE -VISA MENARDS", "LOWES", "AFFINITY PLUMBING", "LEGACY HEATING AND AIR");
    public static String CAR_REPAIR = "Car Repair";
    public static List<String> CAR_REPAIR_ENTITY_LIST = Arrays.asList("SHAKOPEE GOODYEAR", "O'REILLY",
            "DEBIT PURCHASE -VISA SHAKOPEE TIRE", "DEBIT PURCHASE SHAKOPEE TIRE ANSHAKOPEE", "SHAKOPEE TIRE AND AUTO SHAKOPEE");
    public static String TRAVEL = "Travel";
    public static List<String> TRAVEL_ENTITY_LIST = Arrays.asList("AMERICAN", "DELTA", "TRAVELOCITY", "MINNEAPOLIS AIRPORT", "KTA", "UBER", "AA WIFI",
            "MSP REPUBLIC BARD");
    public static String CLOTHES = "Clothes";
    public static List<String> CLOTHES_ENTITY_LIST = Arrays.asList("KOHL'S", "JCPENNEY", "WWW.KOHLS.COM");
    public static String HEALTHCARE = "Healthcare";
    public static List<String> HEALTHCARE_ENTITY_LIST = Arrays.asList("PAY* ALLINA HEALTH", "TWIN CITIES TMJFACI", "MINNESOTA ONCOLOGY HEM",
            "Shakopee Dental", "ROBERT W WARNER DC PA", "SQ *CREEKSIDE PHYSICAL", "DEBIT PURCHASE -VISA SQ *CREEKSIDE", "PT *PARK NICOLLET");
    public static String TAX = "Tax";
    public static List<String> TAX_ENITY_LIST = Arrays.asList("ELECTRONIC DEPOSIT IRS", "ELECTRONIC DEPOSIT MN DEPT OF REVEN", "FREETAXUSA.COM");
    public static List<String> IGNORE_ITEM_LIST = Arrays.asList("MOBILE BANKING PAYMENT TO CREDIT CARD", "MONTHLY MAINTENANCE FEE", "MOBILE PAYMENT THANK YOU", "INTERNET BANKING PAYMENT TO CREDIT CARD",
            "INTERNET PAYMENT THANK YOU");
}
