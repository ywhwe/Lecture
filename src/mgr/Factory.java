package src.mgr;

public interface Factory <T extends Manageable>{
	T create();
}
