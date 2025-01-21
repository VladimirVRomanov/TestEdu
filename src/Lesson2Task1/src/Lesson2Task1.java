package Lesson2Task1.src;
/*
    Реализовать программу «Вендинговый автомат», которая позволит:
    Посмотреть меню напитков
    Внести деньги на внутренний счет
    Выбрать номер напитка и получить его, если на счету достаточно средств.

    Программа должна обрабатывать следующие ситуации:
    Пользователь не внес деньги
    Пользователь выбрал более дорогой напиток, чем внесено денег
    Пользователь выбрал несуществующий номер напитка

    У напитка должна быть цена и название.
 */

public class Lesson2Task1 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Занятие 2, задание 1:");
        System.out.println("Реализовать программу «Вендинговый автомат»");
        System.out.println();

        var vendingMachine = new VendingMachine();
        vendingMachine.run();
    }
}

class VendingMachine {
    private final Drink[] drinks = {new Drink("Вода", 10),
                                    new Drink("Чай", 25),
                                    new Drink("Квас", 50),
                                    new Drink("Кола", 90),
                                    new Drink("Кофе", 100)
                     };
    private int balance;

    public void run() {
        InputIntNumber num = new InputIntNumber(1, 4);
        while (true) {
            showMenu();
            while (!num.inputNumber()) {
                incorrectUserChoice();
                showMenu();
            }
            var userChoice = num.getValue();
            switch (userChoice) {
                case 1:
                    showDrinksMenu();
                    break;
                case 2:
                    addMoney();
                    break;
                case 3:
                    getDrink();
                    break;
                case 4:
                    goodBy();
                    return;
                default:
                    incorrectUserChoice();
            }
        }
    }

    private void showMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1 -> Посмотреть меню напитков");
        System.out.println("2 -> Внести деньги на счет");
        System.out.println("3 -> Получить напиток");
        System.out.println("4 -> Уйти");
        System.out.print("Ваш выбор: ");
    }
    private void showDrinksMenu() {
        System.out.print("\nМеню напитков:");
        showListOfDrinks();
    }
    private void showListOfDrinks() {
        for (int i = 0; i < drinks.length; i++)
            System.out.printf("\n%d -> %4s %3d руб.", i + 1, drinks[i].getName(), drinks[i].getPrice());
        System.out.println();
    }

    private void addMoney() {
        showMoneyPrompt();
        var money = new InputIntNumber(1, Integer.MAX_VALUE);
        while (!money.inputNumber()) {
            System.out.println("Введена некорректная сумма.");
            showMoneyPrompt();
        }
        balance += money.getValue();
        System.out.printf("\nДеньги внесены на счет. Баланс %d руб.\n", balance);
    }

    private void showMoneyPrompt() {
        System.out.print("\nВведите сумму в рублях: ");
    }

    private void getDrink() {
        if (balance == 0) {
            System.out.println("\nВы не внесли деньги на счет. Внесите сумму, достаточную для оплаты напитка.");
            return;
        }
        showDrinkChoicePrompt();
        var num = new InputIntNumber(1, drinks.length);
            while (!num.inputNumber()) {
                incorrectUserChoice();
                showDrinkChoicePrompt();
            }
        var numberOfDrink = num.getValue() - 1;
        if (balance < drinks[numberOfDrink].getPrice()) {
            System.out.printf("\nДля оплаты выбранного напитка \"%s\" ценой %d руб. недостаточно средств на счете: %d руб.\nВнесите еще %d руб. или выберите более дешевый напиток.\n",
                              drinks[numberOfDrink].getName(), drinks[numberOfDrink].getPrice(), balance, drinks[numberOfDrink].getPrice() - balance);
            return;
        }
        balance -= drinks[numberOfDrink].getPrice();
        System.out.printf("\nВы выбрали напиток \"%s\". Возьмите Ваш напиток.", drinks[numberOfDrink].getName());
        showBalance();
    }
    private void getRestOfMoney() {
        if (balance > 0)
            System.out.printf("\nЗаберите оставшиеся деньги: %d руб.\n", balance);
        balance = 0;
    }
    private void showDrinkChoicePrompt() {
        System.out.print("\nВыберите напиток:");
        showListOfDrinks();
        System.out.print("Ваш выбор: ");
    }
    private void showBalance() {
        System.out.printf("\nБаланс: %d руб.\n", balance);
    }
    private void goodBy() {
        getRestOfMoney();
        System.out.println("\nВсего доброго! До новых встреч!\n");
    }
    private void incorrectUserChoice() {
        System.out.println("Выбран несуществующий вариант");
    }
}

class Drink {
    private final String name;
    private final int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
}

