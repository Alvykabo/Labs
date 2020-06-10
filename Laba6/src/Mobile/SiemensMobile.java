package Mobile;

abstract class SiemensMobile implements Mobile {
    Boolean incomingCall;
    Boolean isTalkingNow;
    int siemensSerialNumber;
    abstract void connectToSiemensOnline();
}
