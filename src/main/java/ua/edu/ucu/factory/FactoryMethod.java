package ua.edu.ucu.factory;

interface Viewable {

    public void display(String string, int id);
    
}

class DesktopView implements Viewable {

    @Override
    public void display(String string, int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

class MobileView implements Viewable {

    @Override
    public void display(String string, int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

abstract class ViewApplication {
    public void show(int id){
       Viewable view = createView();
        view.display("Hello " + id, id);
    }

    protected abstract Viewable createView();
}

class DesktopViewApplication  extends ViewApplication {
    @Override
    protected Viewable createView() {
        return new DesktopView();
    }
}

class MobileViewApplication  extends ViewApplication {
    @Override
    protected Viewable createView() {
        return new MobileView();
    }
}
