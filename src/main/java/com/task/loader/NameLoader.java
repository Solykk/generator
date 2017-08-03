package com.task.loader;

/**
 * @author Dmitriy Lyashenko
 */
public class NameLoader {

    private String[] manNames = {
        "Август", "Авдей", "Аверкий", "Аверьян", "Авксентий",
        "Автоном", "Агап", "Агафон", "Аггей", "Адам", "Адриан",
        "Андриян", "Азарий", "Аким", "Александр", "Алексей", "Амвросий",
        "Амос", "Ананий", "Анатолий", "Андрей", "Андрон", "Андроник", "Аникей",
        "Аникита", "Анисим и Онисим", "Антип", "Антонин", "Аполлинарий", "Аполлон",
        "Арефий", "Аристарх", "Аркадий", "Арсений", "Артемий", "Артем", "Архип",
        "Аскольд", "Афанасий", "Афиноген", "Бажен", "Богдан", "Болеслав", "Борис",
        "Борислав", "Боян", "Бронислав", "Будимир", "Вадим", "Валентин", "Валерий",
        "Валерьян", "Варлаам", "Варфоломей", "Василий", "Вацлав", "Велимир",
        "Венедикт", "Вениамин", "Викентий", "Виктор", "Викторин", "Виссарион",
        "Виталий", "Владилен", "Владлен", "Владимир", "Владислав", "Влас",
        "Всеволод", "Всемил", "Всеслав", "Вышеслав", "Вячеслав", "Гаврила", "Гавриил",
        "Галактион", "Гедеон", "Геннадий", "Георгий", "Герасим", "Герман", "Глеб",
        "Гордей", "Гостомысл", "Гремислав", "Григорий", "Гурий", "Давыд", "Давид",
        "Данила", "Даниил", "Дементий", "Демид", "Демьян", "Денис", "Дмитрий", "Добромысл",
        "Доброслав", "Дорофей", "Евгений", "Евграф", "Евдоким", "Евлампий", "Евсей",
        "Евстафий", "Евстигней", "Егор", "Елизар", "Елисей", "Емельян", "Епифан",
        "Еремей", "Ермил", "Ермолай", "Ерофей", "Ефим", "Ефрем", "Захар", "Зиновий",
        "Зосима", "Иван", "Игнатий", "Игорь", "Измаил", "Изот", "Изяслав", "Иларион",
        "Илья", "Иннокентий", "Иосиф", "Oсип", "Ипат", "Ипатий", "Ипполит", "Ираклий",
        "Исай", "Исидор", "Казимир", "Каллистрат", "Капитон", "Карл", "Карп", "Касьян",
        "Ким", "Кир", "Кирилл", "Клавдий", "Климент", "Клементий", "Клим", "Кондрат",
        "Кондратий", "Конон", "Константин", "Корнил", "Корней", "Корнилий", "Кузьма",
        "Куприян", "Лавр", "Лаврентий", "Ладимир", "Ладислав", "Лазарь", "Лев", "Леон",
        "Леонид", "Леонтий", "Лонгин", "Лука", "Лукьян", "Лучезар", "Любим", "Любомир",
        "Любосмысл", "Макар", "Максим", "Максимильян", "Мариан", "Марк", "Мартын", "Мартьян",
        "Матвей", "Мефодий", "Мечислав", "Милан", "Милен", "Милий", "Милован", "Мина", "Мир",
        "Мирон", "Мирослав", "Митофан", "Михаил", "Михей", "Модест", "Моисей", "Мокей", "Мстислав",
        "Назар", "Наркис", "Натан", "Наум", "Нестор", "Никандр", "Никанор", "Никита", "Никифор",
        "Никодим", "Николай", "Никон", "Нифонт", "Олег", "Олимпий", "Онуфрий", "Орест", "Осип",
        "Остап", "Остромир", "Павел", "Панкратий", "Панкрат", "Пантелеймон", "Панфил", "Парамон",
        "Парфен", "Пахом", "Петр", "Пимен", "Платон", "Поликарп", "Порфирий", "Потап", "Пров",
        "Прокл", "Прокофий", "Прохор", "Радим", "Радислав", "Радован", "Ратибор", "Ратмир",
        "Родион", "Роман", "Ростислав", "Рубен", "Руслан", "Рюрик", "Савва", "Савватий",
        "Савелий", "Самсон", "Самуил", "Светозар", "Святополк", "Святослав", "Севастьян",
        "Селиван", "Селиверст", "Семен", "Серафим", "Сергей", "Сигизмунд", "Сидор", "Сила",
        "Силантий", "Сильвестр", "Симон", "Сократ", "Соломон", "Софон", "Софрон", "Спартак",
        "Спиридон", "Станимир", "Станислав", "Степан", "Стоян", "Тарас", "Твердислав", "Творимир",
        "Терентий", "Тимофей", "Тимур", "Тит", "Тихон", "Трифон", "Трофим", "Ульян", "Устин", "Фадей",
        "Федор", "Федосий", "Федот", "Феликс", "Феоктист", "Феофан", "Ферапонт", "Филарет", "Филимон",
        "Филипп", "Фирс", "Флорентин", "Фока", "Фома", "Фортунат", "Фотий", "Фрол", "Харитон", "Харлампий",
        "Христофор", "Чеслав", "Эдуард", "Эммануил", "Эмиль", "Эраст", "Эрнест", "Эрнст", "Ювеналий",
        "Юлиан", "Юлий", "Юрий", "Яков", "Ян", "Якуб", "Януарий", "Ярополк", "Ярослав"      
    };

    private String[] womanNames = {
        "Августа", "Агата", "Агафья", "Аглая", "Агнесса", "Агния", "Аграфена",
        "Агриппина", "Ада", "Аделаида", "Аза", "Алевтина", "Александра", "Алина",
        "Алиса", "Алла", "Альбина", "Анастасия", "Ангелина", "Анисья", "Анна", "Антонида",
        "Антонина", "Анфиса", "Аполлинария", "Ариадна", "Беатриса", "Берта", "Борислава",
        "Бронислава", "Валентина", "Валерия", "Ванда", "Варвара", "Василиса", "Васса", "Вера",
        "Вероника", "Викторина", "Виктория", "Виргиния", "Влада", "Владилена", "Владлена", "Владислава",
        "Власта", "Всеслава", "Галина", "Галя", "Ганна", "Генриетта", "Глафира", "Горислава", "Дарья",
        "Диана", "Дина", "Доминика", "Домна", "Ева", "Евгеиня", "Евдокия", "Евлампия", "Екатерина", "Елена",
        "Елизавета", "Ефросинья", "Ефросиния", "Жанна", "Зинаида", "Злата", "Зоя", "Изабелла", "Изольда",
        "Инга", "Инесса", "Инна", "Ираида", "Ирина", "Ия", "Казимира", "Калерия", "Капитолина", "Каролина",
        "Кира", "Клавдия", "Клара", "Кларисса", "Клементина", "Лариса", "Леокадия", "Лиана", "Лидия", 
        "Лилиана", "Клеопатра", "Конкордия", "Ксения", "Лада", "Лия", "Луиза", "Лукерья", "Любава",
        "Любовь", "Любомила", "Любомира", "Людмила", "Майя", "Мальвина", "Маргарита", "Марианна",
        "Мариетта", "Марина", "Мария", "Марта", "Марфа", "Меланья", "Мелитриса", "Милана", "Милена",
        "Милица", "Мира", "Мирослава", "Млада", "Мстислава", "Муза", "Надежда", "Наталья", "Наталия",
        "Неонила", "Ника", "Нина", "Нинель", "Нона", "Оксана", "Октябрина", "Олимпиада", "Ольга", "Пелагея",
        "Поликсена", "Полина", "Прасковья", "Пульхерия", "Рада", "Раиса", "Регина", "Рената", "Римма",
        "Рогнеда", "Роза", "Розалия", "Розина", "Ростислава", "Руфина", "Светлана", "Серафима",
        "Сильва", "Сильвия", "Саломея", "Софья", "Станислава", "Стела", "Степанида", "Сусанна", "Таисия",
        "Тамара", "Татьяна", "Ульяна", "Фаина", "Федосья", "Фелицата", "Флора", "Флорентина",
        "Фатина", "Харитина", "Христина", "Эвелина", "Элеонора", "Эльвира", "Эмилия", "Эмма", "Юлия", "Ядвига",
        "Ярослава"
    };

    public String[] getManNames() {
        return manNames;
    }

    public String[] getWomanNames() {
        return womanNames;
    }

    public int getManNamesElementsCount(){
        return manNames.length - 1;
    }

    public int getWomanNamesElementsCount(){
        return womanNames.length - 1;
    }
}
