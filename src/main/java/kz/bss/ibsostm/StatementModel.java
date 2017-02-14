package kz.bss.ibsostm;

/**
 * @author Andrey Smirnov
 */
class StatementModel {

    static final String STATEMENT1 =
            "<kz.bss.ibsostm.StatementModel>\n" +
            "              <StatementDate>" ;
    static final String STATEMENT2 =
            "</StatementDate>\n" ;
    static final String STATEMENT3 =
            "              <FromDate>" ;
    static final String STATEMENT4 =
                    "</FromDate>\n";
    static final String STATEMENT5 =
            "              <ToDate>" ;
    static final String STATEMENT6 =
                    "</ToDate>\n" ;
    static final String STATEMENT7 =
            "              <Final>1</Final>\n" ;
    static final String STATEMENT8 =
            "              <Account>";
    static final String STATEMENT9 =
                    "</Account>\n" +
            "              <InBal>100.00</InBal>\n" +
            "              <InBalNat>100.00</InBalNat>\n" +
            "              <OutBal>400.00</OutBal>\n" +
            "              <OutBalNat>400.00</OutBalNat>\n" +
            "              <CreditSum>300.00</CreditSum>\n" +
            "              <CreditSumNat>300.00</CreditSumNat>\n" +
            "              <DebetSum>0.00</DebetSum>\n" +
            "              <DebetSumNat>0.00</DebetSumNat>\n" +
            "              <AccManager>Иванов Иван Иванович</AccManager>\n" +
            "              <docs>\n" +
            "                <DocInfoModel>\n" +
            "                  <DocRef></DocRef>\n" +
            "                  <DocNum>1</DocNum>\n" +
            "                  <DocDate>2013-04-08 18:00:00</DocDate>\n" +
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
            "                  <DocExecDate>2013-06-10 18:00:00</DocExecDate>\n" +
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
            "                  <DocDate>2013-04-08 18:00:00</DocDate>\n" +
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
            "                  <DocExecDate>2013-06-10 18:00:00</DocExecDate>\n" +
            "                  <DocGround>Оплата за услуги</DocGround>\n" +
            "                  <DocGroundCode>180</DocGroundCode>\n" +
            "                  <AddInfo></AddInfo>\n" +
            "                  <ExecutedBy>Пупкин В.В.</ExecutedBy>\n" +
            "                  <DebetAmount>200.00</DebetAmount>\n" +
            "                  <DebetAmountNat>200.00</DebetAmountNat>\n" +
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
            "                  <DocNum>3</DocNum>\n" +
            "                  <DocDate>2013-04-08 18:00:00</DocDate>\n" +
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
            "                  <DocExecDate>2013-06-10 18:00:00</DocExecDate>\n" +
            "                  <DocGround>Оплата за услуги</DocGround>\n" +
            "                  <DocGroundCode>180</DocGroundCode>\n" +
            "                  <AddInfo></AddInfo>\n" +
            "                  <ExecutedBy>Пупкин В.В.</ExecutedBy>\n" +
            "                  <DebetAmount>200.00</DebetAmount>\n" +
            "                  <DebetAmountNat>200.00</DebetAmountNat>\n" +
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
            "                  <DocNum>4</DocNum>\n" +
            "                  <DocDate>2013-04-08 18:00:00</DocDate>\n" +
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
            "                  <DocExecDate>2013-06-10 18:00:00</DocExecDate>\n" +
            "                  <DocGround>Оплата за услуги</DocGround>\n" +
            "                  <DocGroundCode>180</DocGroundCode>\n" +
            "                  <AddInfo></AddInfo>\n" +
            "                  <ExecutedBy>Пупкин В.В.</ExecutedBy>\n" +
            "                  <DebetAmount>200.00</DebetAmount>\n" +
            "                  <DebetAmountNat>200.00</DebetAmountNat>\n" +
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
            "              </docs>\n" +
            "        </kz.bss.ibsostm.StatementModel>";

    private StatementModel() {
        throw new IllegalAccessError("Statement const class");
    }
}
