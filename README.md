# JoraLoger
Микросервис для проекта Jora

## Как запустить
Для запуска потребуется Docker Compose. [Установка Docker Compose](https://docs.docker.com/compose/install/).

### Шаг 1: Клонирование репозитория
Клонируйте репозиторий и перейдите в него:

```bash
git clone https://github.com/oyboy/JoraLoger.git
cd JoraLoger
```

### Шаг 2
Скопируйте файл `.env.sample` в файл `.env`:

Для Linux: 
```bash
cp .env.sample .env
```
Для Windows: 
```cmd
copy .env.sample .env
```

При желании откройте файл .env и измените значения переменных на свои собственные:
```ini
ELASTIC_USERNAME=elastic
ELASTIC_PASSWORD=elastic
```
### Шаг 3
Запустите контейнеры

В Linux: 
```bash
sudo docker compose up
```
В Windows: 
```cmd
docker-compose up
```
