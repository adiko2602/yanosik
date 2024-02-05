## Co można poprawić w strukturze bazy?

1. Kolumna insert_time może w każdej z tabel przyjmować jako DEFAULT now()
2. W tabeli vehicles referencje lepiej zrobić przez id usera
3. Login powinien byc unikalny i niepowtażalny
4. Można dodać tabele insurers z danymi o ubezpieczycielach (eg. nazwa, adres, czy telefon kontaktowy) i poprzez relacje pobierać dane dla ofert ubezpieczeń
5. Podobnie można zrobić z markami i modelami samochodów

## Jak po stronie serwera można zweryfikować czy nadawca komunikatu rzeczywiście jest właścicielem danego konta w tabeli "users"?

Skoro w tabeli users jest przechowywane hasło użytkownika można od takiego użytkownika wymagać autentykacji czyli taki użytkownik musi się najpierw zalogować. Można wygenerować przy logowaniu token, który client użytkownika bedzie za każdym razem wysyłał do serwera a serwer będzie go porównywać z tokenem zapisanym przykładowo w bazie danych. Można również zastosować token który się odświeża oraz taki który traci ważność jeśli użytkownik nie wykonuje przez jakiś czas akcji z serwerem. Przykładem dla aplikacji webowych może być JWT.

## Czy zaproponowane przez Ciebie rozwiązanie można zoptymalizować, aby pozwalało obsłużyć jednocześnie komunikaty od kilku klientów?

Tak można je zoptymalizować w taki sposób. Aby to uzyskać można użyć wątków, które będą obsługiwać różnych klientów równolegle. Należy jednak odrobinę dostosować mój kod aby było to możliwe. Ogólnie mogę nad tym popracować, ponieważ w ramach zaliczeń na studia używałem właśnie takich wątków, aby uruchamiać różne losowe akcje w aplikacji.
