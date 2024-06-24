package remotecontrol.remote;

import remotecontrol.remote.receiver.AutomaticBlind;
import remotecontrol.remote.receiver.Hottub;
import remotecontrol.remote.receiver.Light;
import remotecontrol.remote.receiver.Stereo;

public class FacadeMain {
    public static void main(String[] args) {
        RemoteControlFacade remoteControlFacade = new RemoteControlFacade(new AutomaticBlind("Bathroom"), new Light("Bathroom"), new Stereo("Bathroom"), new Hottub());
        remoteControlFacade.startRelaxMode();
        remoteControlFacade.startPartyMode();
        remoteControlFacade.offMode();
    }
}
