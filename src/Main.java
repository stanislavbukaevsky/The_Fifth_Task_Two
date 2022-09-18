public class Main {
    public static void main(String[] args) {
        String login = "StAnIsLaV_12345";
        String password = "StAnIsLaV_12345";
        String confirmPassword = "StAnIsLaV_12345";
        userRegistration(login, password, confirmPassword);
    }

    public static void userRegistration(String login, String password, String confirmPassword) {
        boolean loginUser = login.matches("^[a-zA-Z0-9_]+$");
        boolean passwordUser = password.matches("^[a-zA-Z0-9_]+$");
        boolean confirmPasswordUser = confirmPassword.matches("^[a-zA-Z0-9_]+$");

        if (login.length() > 20 || !loginUser) {
            try {
                throw new WrongLoginException();
            } catch (WrongLoginException e) {
                System.out.println("Логин должен содержать не более 20 символов! Логин содержит латинские буквы, цифры и знак подчеркивания!");
            }
        } else if (password.length() >= 20 || !passwordUser) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                System.out.println("Пароль должен содержать не более 20 символов! Пароль содержит латинские буквы, цифры и знак подчеркивания!");
            }
        } else if (!password.equals(confirmPassword) || !confirmPasswordUser) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                System.out.println("Пароли не совпадают!");
            }
        } else {
            System.out.println("Вы успешно прошли регистрацию!");
        }

        return;
    }
}