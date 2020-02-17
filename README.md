- Regarding the following question:
"How might you change your implementation to allow other classes to be informed of
changes to the stack?"

A generic stack implementation was made in StackImpl.

Another implementation was made in ObservableStackImpl with the use of the Observable from java.util.

Adding notification methods on either push and pop methods, will notify the Observers whenever there is a
change in one of these methods, in this case the observer is ObserverSubject.

Hence applying the Observer Design Pattern.



