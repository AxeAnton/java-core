package ru.itmo.lessons.lessons21.patterns.builder;

public class TstNutrition { // 1. Патерн Builder используется для создания объекта с большим количеством хорактеристик(свойств), причем одни обязательные в нашем случаи это количество кусочков serving, и не обязательных. Основной момент, что билдет позволяет создать цепочку НЕ обязательных свойств и в процессе внесения значений данным свойствам, после каждого внесения возвращает ссылку на текущий объет (12.1), это и позволяет создать цепочку свойств.
    public static void main(String[] args) {
        //  // Builder: servings: 3, calories: 200, fat: 4
        NutritionFacts appleFacts =
                new NutritionFacts.Builder(3) // 2. количество порщий - обязательное свойство
                        .calories(200)// 3. перечесление методов или свойств (не очень понятно)
                        .fat(4)
                        .build(); // 4. создание объектов
        System.out.println(appleFacts);
    }
}
