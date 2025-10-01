package org.codepo.experience.others.pyatkov;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

/**
 * Компания предоставляет сервис массовой рассылки уведомлений для других бизнесов. К вам обратился product owner с задачей создать систему
 * фильтрации уведомлений с учетом предпочтений пользователей.
 * <pre>
 * ## Определения
 *  Уведомление:
 *      - id уведомления
 *      - тип уведомления (EMAIL, SMS, PUSH)
 *      - получатель (id пользователя)
 *      - текст сообщения
 *
 *  Получатель может иметь настройки предпочтений:
 *      - разрешенные каналы уведомлений (список типов)
 *      - заблокированные отправители (список id отправителей)
 *
 *  История отправленных уведомлений:
 *      - список уведомлений, отправленных пользователю
 *
 * ## Важно
 *  Настройки пользователей и история уведомлений предоставляются другими компонентами системы.
 *  Вам необходимо спроектировать контракты для получения этих данных.
 *  Реализацию хранения делать не нужно.
 *
 * ## Задача
 *  Написать систему фильтрации уведомлений, которая:
 *      - на вход получает список уведомлений для фильтрации и id отправителя
 *      - исключает уведомления, не соответствующие предпочтениям получателя
 *      - предотвращает повторную отправку:
 *          если уведомление с таким же id уже было отправлено конкретному пользователю за последние 24 часа, оно не должно быть отправлено
 *          снова (защита от дублирования)
 *      - возвращает отфильтрованный список уведомлений, готовых к отправке.
 *
 *  Отправка уведомлений не входит в вашу задачу - другая команда займется отправкой отфильтрованного списка.
 *  Ваша задача - только фильтрация.
 * </pre>
 * <pre>
 *  Со слов Влада, интервьюверу было важно чтобы было все протестировано с использованием моков.
 *  Никаких сложных структур или алогоритмов не требовалось.
 *  Обсуждались интерфейсы и создание проекта.
 * </pre>
 */
class YandexFilteringNotifications {
    enum NotificationType {
        EMAIL, SMS, PUSH;
    }

    static class Notification {
        final long id;

        final NotificationType type;

        final long senderId;

        final String body;

        Notification(long id, NotificationType type, long senderId, String body) {
            this.id = id;
            this.type = type;
            this.senderId = senderId;
            this.body = body;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Notification that = (Notification) o;

            return id == that.id;
        }

        @Override
        public int hashCode() {
            return (int) (id ^ (id >>> 32));
        }
    }

    static class NotificationPreferences {
        final Set<NotificationType> availableNotificationTypes = ConcurrentHashMap.newKeySet();

        final Set<Long> blockedSenderIds = ConcurrentHashMap.newKeySet();
    }

    static class NotificationHistory {
        final Set<Notification> notifications;

        NotificationHistory(Set<Notification> notifications) {
            this.notifications = notifications;
        }
    }

    static NotificationPreferences getNotificationPreferences(long userId) {
        return new NotificationPreferences();
    }

    static NotificationHistory getNotificationHistory(long userId) {
        return new NotificationHistory(Set.of());
    }

    static List<Notification> filter(long receiverId, List<Notification> notifications) {
        NotificationPreferences notificationPreferences = getNotificationPreferences(receiverId);
        NotificationHistory notificationHistory = getNotificationHistory(receiverId);

        return notifications.stream()
                .filter(Predicate.not(notificationHistory.notifications::contains))
                .filter(notification -> notificationPreferences.availableNotificationTypes.contains(notification.type))
                .filter(notification -> !notificationPreferences.blockedSenderIds.contains(notification.senderId))
                .collect(toList());
    }
}
