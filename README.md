# adapter-delegation-example
A sample app to compare the implementation of the adapter delegation libraries below.

#### Groupie - https://github.com/lisawray/groupie
✅ Out of the box support for sections

❌ No support for ViewBinding (yet)<br />
❌ Little bit more boilerplate<br />
❌ No out of the box support for saving nested recycler state<br />
❌ Need to map view data objects to `Group`s (equivalent to `ViewHolder`s)

#### AdapterDelegates - https://github.com/sockeqwe/AdapterDelegates
✅ Easy and concise syntax, easy to use<br />
✅ Support for ViewBinding

❌ No out of the box support for saving nested recycler state

#### Cycler - https://github.com/square/cycler
✅ Concise syntax<br />
✅ Support for ViewBinding<br />
✅ Support for a completely different item at the bottom of the list<br />
✅ Out of the box support for saving nested recycler state<br />
✅ Calculating diffs with coroutines

❌ Has it's own DSL, so it has a higher learning curve<br />
❌ Library is in early state, so there are some missing/weird things
