package ru.itmo.lessons.lessons21.patterns.builder;

public class NutritionFacts {
    // 5. обязательные параметры
    private final int servings;
    // 6. необязательные параметры
    private final int calories;
    private final int fat;

    public static class Builder { //7. Класс БИЛДЕР создает экземпляры NutritionFacts- внешенего класса
        // 8. обязательные парамерты
        private final int servings;
        // 9. необязательные параметры, инициализируются
        // 10. значениями по умолчанию
        private int calories = 1;
        private int fat;

        // 11. значения обязательных устанавливаем через конструктор
        public Builder(int servings) {
            this.servings = servings;
        }

        // 12. для остальных, что то вроде сеттеров
        public Builder calories(int caloriesVal){
            calories = caloriesVal; // изменение объекта
            return this; // 12.1 возвращаем ссылку на текущий измененный объект
        }

        public Builder fat(int fatVal){ // 13. то же самое, что и 12
            fat = fatVal; // изменение объекта
            return this; // возвращаем ссылку на текущий измененный объект
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        } // 14. Важный МЕТОД (создает объект внешнего класса), для данного Патерна это метод ВНЕШНЕГО класса, он передает ссылку на bilder,
    }

    private NutritionFacts(Builder builder){ // 15. здесь ссылка на билдер принимается (это кстати конструктор ВНЕШНЕГО класса) от 14 и записываются
        servings = builder.servings; // 16. значение свойства для внешнего класса (NutritionFacts) будет равно свойству из внутреннего КЛАССА билдер.
        calories = builder.calories;
        fat = builder.fat;
    }


    @Override
    public String toString() { // 17. для вывода
        return "NutritionFacts{" +
                "servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                '}';
    }
}
