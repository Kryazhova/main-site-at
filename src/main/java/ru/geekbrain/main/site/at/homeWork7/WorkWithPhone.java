package ru.geekbrain.main.site.at.homeWork7;

public class WorkWithPhone {
    public static void main(String[] args) {
        Telephone noted = new Telephone();

        //внутри проверка на валидость номера телефона
        //если номер телефона невалидный, то не доллжна быть возможна работа со справочником
        noted.add("Толстой", "89991112233");
        noted.add("Пушкин", "+78767654321");
        noted.add("Грибоедов", "8(123)1234567");
        noted.add("Лермонтов", "+7(444)1234567");
        noted.add("Обухов", "+7(444)1234567");
        noted.add("Лермонтов", "+7(555)1234567");

        noted.get("Толстой");
        noted.get("Лермонтов");

    }
}
