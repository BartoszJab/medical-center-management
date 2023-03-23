# Zarządzanie ośrodkiem medycznym

## Uruchamianie aplikacji

## Endpointy

Aplikacja posiada podstawowe uwierzytelnianie. Użytkownicy mogą mieć jedną z trzech ról: Administrator, Pracownik, Pacjent. Utworzone zostały 3 konta testowe:

* <b><i>Administrator</i></b> ma dostęp do wszystkich zasobów oraz ich dodawania/modyfikowania/usuwania

```
Nazwa użytkownika   Hasło
---------------------------------
admin               adminpassword
``` 
    
* <b><i>Pracownik</i></b> ma dostęp do pobierania wszystkich zasobów

```
Nazwa użytkownika   Hasło
------------------------------------
employee            employeepassword
``` 
    
 
* <b><i>Pacjent</i></b> ma dostęp do pobierania tylko swoich zasobów

```
Nazwa użytkownika   Hasło
-----------------------------------
patient             patientpassword
``` 

### Pacjenci

1. Pobierz wszystkich pacjentów: http://localhost:8080/patients <b>GET</b>

2. Pobierz pacjenta o podanym id: http://localhost:8080/patients/{id} <b>GET</b>

3. Pobierz dane kontaktowe pacjenta o podanym id: http://localhost:8080/patients/{id}/contacts <b>GET</b>

4. Pobierz wyniki badań pacjenta o podanym id: http://localhost:8080/patients/{id}/results <b>GET</b>

5. Pobierz projekty badawcze, do których należy pacjent o podanym id: http://localhost:8080/patients/{id}/projects <b>GET</b>

6. Utwórz pacjenta: http://localhost:8080/patients <b>POST</b>

Przykładowe RequestBody: 
```
{
  "firstName": "Jan",
  "lastName": "Kowalski",
  "dateOfBirth": "1985-01-12",
  "gender": "MALE"
}
```

7. Aktualizuj pacjenta o id: http://localhost:8080/patients/{id} <b>PUT</b>

RequestBody jak w przypadku dodawania

8. Usuń pacjenta o id: http://localhost:8080/patients/{id} <b>DELETE</b>

### Dane kontaktowe
1. Utwórz dane kontaktowe dla pacjenta: http://localhost:8080/contacts <b>POST</b>

Przykładowe RequestBody: 
```
{
  "phoneNumber": "111111111",
  "email": "kowalski@jan.com",
  "address": "Kowalski Street",
  "patientId": 1
}
```

2. Aktualizuj dane kontaktowe o id: http://localhost:8080/contacts/{id} <b>PUT</b>

RequestBody jak w przypadku dodawania

3. Usuń dane kontaktowe o id: http://localhost:8080/contacts/{id} <b>DELETE</b>

### Projekty badawcze

1. Pobierz wszystkie projekty: http://localhost:8080/projects <b>GET</b>

2. Utwórz projekt: http://localhost:8080/projects <b>POST</b>

Przykładowe RequestBody: 
```
{
  "title": "Project title",
  "description": "Project description"
}
```

3. Przypisz pacjenta do projektu http://localhost:8080/projects/patients <b>POST</b>

Przykładowe RequestBody: 
```
{
  "patientId": 1,
  "projectId": 2
}
```

4. Aktualizuj projekt o id: http://localhost:8080/projects/{id} <b>PUT</b>

RequestBody jak w przypadku dodawania

5. Usuń projekt o id: http://localhost:8080/projects/{id} <b>DELETE</b>

6. Usuń powiązanie pacjenta z projektem: http://localhost:8080/projects/{id}/patients/{patientId} <b>DELETE</b>

### Zgody pacjentów
1. Pobierz wszystkie zgody: http://localhost:8080/agreements <b>GET</b>

2. Utwórz nową zgodę: http://localhost:8080/agreements <b>POST</b>

Przykładowe RequestBody: 
```
{
  "patientId": 1,
  "projectId": 2
}
```

3. Usuń zgodę pacjenta na udział w danym projekcie: http://localhost:8080/agreements/patients/{patientId}/projects/{projectId} <b>DELETE</b>

### Zlecenia na badania
1. Pobierz wszystkie zlecenia: http://localhost:8080/orders <b>GET</b>

2. Utwórz nowe zlecenie: http://localhost:8080/orders <b>POST</b>

Przykładowe RequestBody: 
```
{   
  "researchDate": "1985-01-12T14:30:00",
  "patientId": 1,
  "projectId": 3
}
```

### Wyniki testów laboratoryjnych
1. Utwórz test: http://localhost:8080/results <b>POST</b>

Przykładowe RequestBody: 
```
{
  "testType": "Blood test",
  "resultDescription": "Result description",
  "orderId": 1
}
```

2. Aktualizuj wyniki o id: http://localhost:8080/results/{id} <b>PUT</b>

RequestBody jak w przypadku dodawania

3. Usuń wyniki o id: http://localhost:8080/results/{id} <b>DELETE</b>
