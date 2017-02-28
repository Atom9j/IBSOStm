package kz.bss.ibsostm.handling;

/**
 * @author Andrey Smirnov
 */
public class Consts
{

    public static final String CONF_PATH = "conf.properties";

    public static final String SAVE_CONFIG = "Save_config";

    public static final String NO_CONF = "Текущей схемы нет!";

    public static final String OK_CONF = "Текущая схема ";

    //Файл настроек подключения
    public static final String URL = "jdbc.URL";

    public static final String USER = "jdbc.USER";

    public static final String PASS = "jdbc.PASS";

    public static final String JDBC = "=jdbc:oracle:thin:@";

    public static final String CATALINA = "CATALINA_HOME";

    public static final String FLDR = "webapps";

    //Выписка
    static final String STATEMENT1 =
            "<StatementModel>\n" +
                    "              <StatementDate>";
    static final String STATEMENT2 =
            "</StatementDate>\n";
    static final String STATEMENT3 =
            "              <FromDate>";
    static final String STATEMENT4 =
            "</FromDate>\n";
    static final String STATEMENT5 =
            "              <ToDate>";
    static final String STATEMENT6 =
            "</ToDate>\n";
    static final String STATEMENT7 =
            "              <Final>1</Final>\n";
    static final String STATEMENT8 =
            "              <Account>";
    static final String STATEMENT9 =
            "</Account>\n" +
                    "              <InBal>400.00</InBal>\n" +
                    "              <InBalNat>400.00</InBalNat>\n" +
                    "              <OutBal>400.00</OutBal>\n" +
                    "              <OutBalNat>400.00</OutBalNat>\n" +
                    "              <CreditSum>200.00</CreditSum>\n" +
                    "              <CreditSumNat>200.00</CreditSumNat>\n" +
                    "              <DebetSum>200.00</DebetSum>\n" +
                    "              <DebetSumNat>200.00</DebetSumNat>\n" +
                    "              <AccManager>Иванов Иван Иванович</AccManager>\n" +
                    "              <docs>\n" +
                    "                <DocInfoModel>\n" +
                    "                  <DocRef></DocRef>\n" +
                    "                  <DocNum>1</DocNum>\n" +
                    "                  <DocDate>2017-02-28 00:00:00</DocDate>\n" +
                    "                  <PayerAccount>KZ88781513477102328</PayerAccount>\n" +
                    "                  <PayerCurrCode>KZT</PayerCurrCode>\n" +
                    "                  <PayerBin>330205694842</PayerBin>\n" +
                    "                  <PayerName>SweetLine</PayerName>\n" +
                    "                  <PayerKbe>17</PayerKbe>\n" +
                    "                  <PayerBankBic>JSRBKZKA</PayerBankBic>\n" +
                    "                  <BenefBankBic>ABKZKZKX</BenefBankBic>\n" +
                    "                  <BenefBankAccount></BenefBankAccount>\n" +
                    "                  <BenefAccount>KZ10319N010000387203</BenefAccount>\n" +
                    "                  <BenefBin>671109224103</BenefBin>\n" +
                    "                  <BenefName>Товарищество</BenefName>\n" +
                    "                  <BenefKbe>17</BenefKbe>\n" +
                    "                  <DocExecDate>2017-02-28 00:00:00</DocExecDate>\n" +
                    "                  <DocGround>Оплата за услуги</DocGround>\n" +
                    "                  <DocGroundCode>180</DocGroundCode>\n" +
                    "                  <AddInfo></AddInfo>\n" +
                    "                  <ExecutedBy>Пупкин В.В.</ExecutedBy>\n" +
                    "                  <DebetAmount>300.00</DebetAmount>\n" +
                    "                  <DebetAmountNat>300.00</DebetAmountNat>\n" +
                    "                  <CreditAmount>0.00</CreditAmount>\n" +
                    "                  <CreditAmountNat>0.00</CreditAmountNat>\n" +
                    "                  <PayerBankName>АО ТЕМIРБАНК</PayerBankName>\n" +
                    "                  <BenefBankName>АО БТА Банк</BenefBankName>\n" +
                    "                  <BenefCurrCode></BenefCurrCode>\n" +
                    "                  <Executive></Executive>\n" +
                    "                  <ChiefAccountant></ChiefAccountant>\n" +
                    "                  <Urgent>false</Urgent>\n" +
                    "                  <NDS>false</NDS>\n" +
                    "                  <DocType>3</DocType>\n" +
                    "                </DocInfoModel>\n" +
                    "                <DocInfoModel>\n" +
                    "                  <DocRef></DocRef>\n" +
                    "                  <DocNum>2</DocNum>\n" +
                    "                  <DocDate>2017-02-28 00:00:00</DocDate>\n" +
                    "                  <PayerAccount>KZ077812203173980174</PayerAccount>\n" +
                    "                  <PayerCurrCode>KZT</PayerCurrCode>\n" +
                    "                  <PayerBin>330205694842</PayerBin>\n" +
                    "                  <PayerName>SweetLine</PayerName>\n" +
                    "                  <PayerKbe>17</PayerKbe>\n" +
                    "                  <PayerBankBic>JSRBKZKA</PayerBankBic>\n" +
                    "                  <BenefBankBic>ABKZKZKX</BenefBankBic>\n" +
                    "                  <BenefBankAccount></BenefBankAccount>\n" +
                    "                  <BenefAccount>KZ10319N010000387203</BenefAccount>\n" +
                    "                  <BenefBin>671109224103</BenefBin>\n" +
                    "                  <BenefName>Товарищество</BenefName>\n" +
                    "                  <BenefKbe>17</BenefKbe>\n" +
                    "                  <DocExecDate>2017-02-28 00:00:00</DocExecDate>\n" +
                    "                  <DocGround>Оплата за услуги</DocGround>\n" +
                    "                  <DocGroundCode>180</DocGroundCode>\n" +
                    "                  <AddInfo></AddInfo>\n" +
                    "                  <ExecutedBy>Пупкин В.В.</ExecutedBy>\n" +
                    "                  <DebetAmount>0.00</DebetAmount>\n" +
                    "                  <DebetAmountNat>0.00</DebetAmountNat>\n" +
                    "                  <CreditAmount>200.00</CreditAmount>\n" +
                    "                  <CreditAmountNat>200.00</CreditAmountNat>\n" +
                    "                  <PayerBankName>АО ТЕМIРБАНК</PayerBankName>\n" +
                    "                  <BenefBankName>АО БТА Банк</BenefBankName>\n" +
                    "                  <BenefCurrCode></BenefCurrCode>\n" +
                    "                  <Executive></Executive>\n" +
                    "                  <ChiefAccountant></ChiefAccountant>\n" +
                    "                  <Urgent>false</Urgent>\n" +
                    "                  <NDS>false</NDS>\n" +
                    "                  <DocType>3</DocType>\n" +
                    "                </DocInfoModel>\n" +
                    "              </docs>\n" +
                    "        </StatementModel>";

    private Consts()
    {
        throw new IllegalAccessError("Statement const class");
    }
}
