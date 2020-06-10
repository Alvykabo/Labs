package Mobile;

public class Model extends SiemensMobile {
    @Override
    void connectToSiemensOnline() {
        System.out.println("Подсоединились к сервису Сименс Онлайн");
    }

    @Override
    public void startCall(String number) {
        isTalkingNow = true;
    }

    @Override
    public String searchForCall() {
        while (true){
            if (incomingCall){
                if (isTalkingNow){
                    return "Линяя занята";
                } else return "Вызов принят";
            }
        }
    }

    @Override
    public void acceptCall(String number) {
        isTalkingNow = true;

    }

    @Override
    public void breakCall() {
        isTalkingNow = false;
    }
}
