# cp-refresh-token-Accept-Language-ignore
[Cuba Platform] Демонстрация проблемы игнорирования Accept-Language при запросе на получение нового access токена с помощью refresh токена

1. Запустить приложение. Далее
2. Получить access токен
```
curl -d "username=admin&password=admin&grant_type=password" -H "Content-Type: application/x-www-form-urlencoded" -H "Authorization: Basic Y2xpZW50OnNlY3JldA==" -H "Accept-Language: ru" -X POST http://localhost:8080/app/rest/v2/oauth/token
```
Пример ответа
```
{"access_token":"2b8043fe-c05e-4c4c-b13f-7f1b1ff7e06e","token_type":"bearer","refresh_token":"429abc8c-7b27-48d7-b7f0-7202e4209405","expires_in":43199,"scope":"rest-api"}
```
3. Проверить язык клиентской сессии
```
curl -H "Authorization: Bearer 2b8043fe-c05e-4c4c-b13f-7f1b1ff7e06e" -X GET http://localhost:8080/app/rest/demo-locale
```
В ответ вернётся язык, указанный при получении токена
```
ru
```
4. Получить новый токен, используя refresh
```
curl -d "refresh_token=429abc8c-7b27-48d7-b7f0-7202e4209405&grant_type=refresh_token" -H "Content-Type: application/x-www-form-urlencoded" -H "Authorization: Basic Y2xpZW50OnNlY3JldA==" -H "Accept-Language: ru" -X POST http://localhost:8080/app/rest/v2/oauth/token
```
Пример ответа
```
{"access_token":"36227380-833a-4147-884d-87c9dcfe4d92","token_type":"bearer","refresh_token":"429abc8c-7b27-48d7-b7f0-7202e4209405","expires_in":43199,"scope":"rest-api"}
```
5. Снова проверить язык клиентской сессии
```
curl -H "Authorization: Bearer 36227380-833a-4147-884d-87c9dcfe4d92" -X GET http://localhost:8080/app/rest/demo-locale
```
В ответ вернётся язык системы по умолчанию
```
en
```
