# Лабораторна робота №4

## З дисципліни «Програмування мобільних пристроїв на базі ОС Android»

## Тема: «Локальна база даних Room та Repository в Android-застосунку»


студент групи АІ-233
Мельник О.Д
Варіант 10

----

### Завдання

У даній лабораторній роботі необхідно розробити Android-застосунок з трьома екранами та навігаційною системою, яка управляє переходами між екранами
Варіант 5: "Мої рецепти"
Екрани
1. RecipesListScreen - Список рецептів
•	Список всіх рецептів (назва + час приготування)
•	Кнопка "+" для додавання нового рецепту
•	При клику на рецепт → перехід на DetailsScreen з ID рецепту
2. AddRecipeScreen (Додавання рецепту)
Призначення: Форма для створення нового рецепту.
Функціональність:
•	Поле для введення назви рецепту
•	Поле для списку інгредієнтів
•	Поле для інструкцій приготування
•	Поле для часу приготування (у хвилинах)
•	Кнопка "Зберегти" - додає рецепт і повертається на Екран 1
•	Кнопка "Скасувати" - повертається назад без збереження
Переходи:
•	AddRecipeScreen → RecipesListScreen (кнопка "Зберегти" або "Скасувати")
3. DetailsRecipeScreen - Деталі рецепту
•	Отримує ID рецепту як аргумент
•	Показує назву, інгредієнти, інструкції та час приготування
•	Рейтинг складності (Легко/Середньо/Складно)
•	Кнопка "Редагувати" (переходить на AddScreen з ID рецепту)
•	Кнопка "Видалити" (видаляє рецепт і повертається на екран 1)
•	Кнопка "Назад"
Вимоги
•	Навігація між 3 екранами
•	Передача ID рецепту як аргумент: "details/{recipeId}"
•	ViewModel для управління даними (List рецептів)
•	Додавання, видалення, редагування рецептів
•	Кнопки "Назад" та popBackStack()

----

###  Вигляд розробленої програми 

<img width="377" height="796" alt="image" src="https://github.com/user-attachments/assets/57cc8d3d-0551-4865-94a6-0431e7463269" />

При запуску програми

<img width="357" height="635" alt="image" src="https://github.com/user-attachments/assets/76b45319-9ab5-4d12-bae5-d9cb677ebc9d" />
<img width="339" height="661" alt="image" src="https://github.com/user-attachments/assets/4c29d2ad-0db1-4bfb-bc1d-e5bdbca4f888" />

Створення нового рецепту

<img width="350" height="626" alt="image" src="https://github.com/user-attachments/assets/75ddd6d9-89b7-4220-b7c7-296678e14f59" />

Перегляд деталей рецепту

<img width="354" height="664" alt="image" src="https://github.com/user-attachments/assets/9dd37d45-ccdf-4075-949a-1a44c4ec3e99" />

Після видалення рецепту

<img width="352" height="663" alt="image" src="https://github.com/user-attachments/assets/eefb9a8e-ff77-496b-822b-ee49d4eda602" />

Після поновлення роботи 

<img width="382" height="792" alt="image" src="https://github.com/user-attachments/assets/8a21bfeb-be17-4465-9040-06be46b10a25" />
<img width="375" height="787" alt="image" src="https://github.com/user-attachments/assets/f573d119-1c1c-4306-9fb6-d4f80e1d9daa" />
<img width="392" height="798" alt="image" src="https://github.com/user-attachments/assets/39f25899-c9e3-40c9-bae3-d34e2e6b0497" />

Редагування рецепту 
