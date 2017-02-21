package com.weasel.frp;

import com.weasel.frp.domain.Company;
import com.weasel.frp.domain.Persion;
import com.weasel.frp.infrastructure.ini.IniReader;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author Dylan
 * @date 2017/1/18.
 */

public class IniReaderTest {

    private static final String CONFIG_NAME = "frpc.ini";
    private static final String SYSTEM = "system";
    private static final String COMPANY = "company";
    private static final String PROGRAM_NAME = "program_name";
    private static final String VERSION = "version";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String SEX = "sex";
    private static final String ADDRESS = "address";

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {

        System.out.println(StringUtils.center("system",20,"#"));
        printOne();
        System.out.println(StringUtils.center("company",20,"#"));
        printList();
        System.out.println(StringUtils.center("persion",20,"#"));
        printRegular();

    }

    public static void printOne() throws IOException, InstantiationException, IllegalAccessException {
        IniReader reader = IniReader.create()
                                    .load(CONFIG_NAME);

        com.weasel.frp.domain.System system = reader.readOne(SYSTEM)
                                                    .to(com.weasel.frp.domain.System.class);
        System.out.println("program : " + system.getProgram() + ",version : " + system.getVersion());
    }

    public static void printList() throws IOException, InstantiationException, IllegalAccessException {
        IniReader reader = IniReader.create()
                                    .load(CONFIG_NAME);

        List<Company> companys = reader.readList(COMPANY)
                                       .to(Company.class);
        companys.forEach(company -> System.out.println("name : " + company.getName() + ",address : " + company.getAddress()));

    }

    public static void printRegular() throws IOException {
        IniReader reader = IniReader.create()
                                    .load(CONFIG_NAME);

        List<Persion> persions = reader.readRegular("person_*").to(Persion.class);

        persions.forEach(persion -> System.out.println("name : " + persion.getName() + ",age : " + persion.getAge() + ",sex : " + persion.getSex()));

    }


}
