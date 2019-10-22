Надо написать веб-приложение, цель которого - операции со счетами пользователей.

Должно быть 3 API (RESTful):
 - перевод денег с одного счёта на другой, 
 - положить деньги на счёт, 
 - снять деньги со счёта. 

Отрицательный баланс счета недопустим.
В качестве хранилища можно использовать любую in-memory БД. 
Доступ к БД осуществить через JPA.

Исходный код должен собираться с помощью maven или gradle в исполняемый jar. 
Решение должно быть на Java или Kotlin. 


Rest Api

http://localhost/account/list GET - получить список аккаунтов
http://localhost/account POST - сохранить аккаунт пример: 
{
    "amount": 200,
    "number": 23
}
http://localhost/account/add PUT - Добавит к счету сумму пример:
{
    "amount": 10,
    "number": 22
}
http://localhost/account/withdraw PUT - Вычесть сумму из счета пример:
{
    "amount": 10,
    "number": 22
}
http://localhost/account/transaction POST - Перевести с одного счета на другой пример:
{
    "from": 22,
    "to": 23,
    "amount" :100
}