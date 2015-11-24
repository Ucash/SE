:- dynamic
	djest/1,
	djest/2,
	dnie_jest/1.

zagraj(age_of_empires_2) :- jest_gatunku(rts),
	jest(1, dluga),
	nie_jest(nowa),
	nie_jest(turowa),
	jest(rywalizacyjna).

zagraj(heroes_3) :- jest_gatunku(rts),
	jest(2, dluga),
	nie_jest(nowa),
	jest(turowa),
	jest(rywalizacyjna).

zagraj(civilization_5) :- jest_gatunku(rts),
	jest(2, dluga),
	jest(turowa),
	jest(rywalizacyjna),
	jest(nowa).

zagraj(theme_park_world) :- jest_gatunku(rts),
	nie_jest(turowa),
	jest(familijna),
	jest(zabawna).

zagraj(lol) :- jest_gatunku(moba),
	jest(nowa).

zagraj(dota) :- jest_gatunku(moba),
	nie_jest(nowa).

zagraj(tibia) :- jest_gatunku(mmorpg),
	nie_jest(nowa),
	jest(prosta).

zagraj(wow) :- jest_gatunku(mmorpg),
	jest(nowa),
	nie_jest(prosta).

zagraj(the_sims) :- jest_gatunku(rts),
	jest(2, dluga),
	nie_jest(online),
	jest(familijna).

zagraj(dyna) :-	nie_jest(online),
	nie_jest(nowa),
	nie_jest(turowa),
	jest(rywalizacyjna),
	jest(0,dluga),
	jest(prosta).

zagraj(cs) :- jest_gatunku(fps),
	jest(realistyczna),
	jest(online).

zagraj(quake) :- jest_gatunku(fps),
	nie_jest(nowa),
	nie_jest(realistyczna).

zagraj(call_of_duty) :- jest_gatunku(fps),
	jest(realistyczna),
	nie_jest(online).

zagraj(munchkin) :- nie_jest(komputerowa),
	jest_gatunku(rpg),
	nie_jest(planszowa),
	jest(nowa),
	jest(zabawna),
	jest(2, osobowa).


zagraj(magia_i_miecz) :-nie_jest(komputerowa),
	jest_gatunku(rpg),
	jest(turowa),
	jest(planszowa),
	jest(nowa),
	nie_jest(prosta).

zagraj(szachy) :- jest_gatunku(ags),
	jest(planszowa),
	nie_jest(nowa),
	jest(1, dluga).

zagraj(mlynek) :- jest_gatunku(ags),
	jest(planszowa),
	nie_jest(nowa),
	jest(0, dluga).

zagraj(brydz) :- jest_gatunku(ags),
	nie_jest(nowa),
	nie_jest(planszowa).

zagraj(neuroshima) :- nie_jest(komputerowa),
	jest_gatunku(wojenna),
	jest(planszowa),
	jest(nowa),
	nie_jest(realistyczna).

zagraj(polska1939) :- nie_jest(komputerowa),
	jest_gatunku(wojenna),
	jest(realistyczna),
	jest(planszowa).

zagraj(eurobusiness) :- jest_gatunku(eurogra),
	nie_jest(nowa),
	jest(planszowa),
	nie_jest(kreatywna).

zagraj(monopoly) :- jest_gatunku(eurogra),
	jest(nowa),
	jest(planszowa),
	nie_jest(kreatywna).

zagraj(carcassone) :- nie_jest(komputerowa),
	jest_gatunku(eurogra),
	nie_jest(planszowa),
	jest(nowa),
	jest(kreatywna).

zagraj(gra_o_tron) :- nie_jest(komputerowa),
	jest_gatunku(ameritrash),
	jest(planszowa).

zagraj(doodle) :- nie_jest(komputerowa),
	jest_gatunku(imprezowa),
	jest(dynamiczna),
	nie_jest(planszowa),
	jest(familijna),
	jest(1, osobowa).

zagraj(dixit) :- nie_jest(komputerowa),
	jest_gatunku(imprezowa),
	jest(kreatywna),
	jest(planszowa),
	nie_jest(familijna),
	jest(2,osobowa).

zagraj(mafia) :- nie_jest(komputerowa),
	jest_gatunku(imprezowa),
	nie_jest(planszowa),
	jest(familijna),
	jest(2, osobowa),
	jest(kreatywna),
	jest(realistyczna).

jest_gatunku(rts) :- jest(komputerowa),
	jest(umyslowa),
	jest(0, osobowa),
	jest(fabularna),
	jest(kreatywna).

jest_gatunku(moba) :- jest_gatunku(ggr),
	jest(online),
	jest(umyslowa),
	nie_jest(realistyczna).

jest_gatunku(fps) :- jest_gatunku(ggr),
	nie_jest(umyslowa),
	nie_jest(kreatywna).

jest_gatunku(ggr) :- /* grupowa gra rywalizacyjna */
	jest(grupowa),
	jest(dynamiczna),
	nie_jest(turowa),
	jest(0, dluga),
	nie_jest(familijna),
	jest(rywalizacyjna).

jest_gatunku(mmorpg) :- jest(online),
	nie_jest(familijna),
	nie_jest(turowa),
	jest_gatunku(rpg). /* ?? */

jest_gatunku(rpg):- jest(fabularna),
	jest(2, dluga),
	nie_jest(grupowa),
	jest(1, losowa),
	jest(kreatywna).

jest_gatunku(ags) :- /* abstrakcyjna gra strategiczna */
	jest(prosta),
	nie_jest(fabularna),
	jest(turowa),
	jest(0, losowa),
	nie_jest(kreatywna).

jest_gatunku(wojenna) :-
	jest(realistyczna),
	jest(rywalizacyjna),
	nie_jest(prosta),
	jest(1, losowa),
	jest(umyslowa).

jest_gatunku(eurogra) :-
	jest(umyslowa),
	jest(familijna),
	jest(turowa),
        jest(1, losowa).

jest_gatunku(ameritrash) :-
	nie_jest(prosta),
	jest(fabularna),
	jest(2, losowa),
	jest(umyslowa),
	nie_jest(grupowa),
	jest(2, dluga),
	jest(2, osobowa).

jest_gatunku(imprezowa):-
	jest(prosta),
	nie_jest(umyslowa),
	jest(2, losowa),
	nie_jest(fabularna),
	jest(zabawna),
	jest(0,dluga).

jest(komputerowa) :- jest(online), !.

jest(X) :- djest(X), !.
jest(X) :- \+dnie_jest(X).

nie_jest(X) :- dnie_jest(X), !.
nie_jest(X) :- \+djest(X).

jest(X,Y) :- djest(X,Y), !.
jest(_,Y) :- \+djest(_,Y).

pamietaj(X,t) :- assertz(djest(X)).
pamietaj(X,n) :- assertz(dnie_jest(X)).
pamietaj(X,o) :- assertz(dnie_jest(X)),assertz(djest(X)).

pamietaj2(o,X) :- assertz(djest(0,X)),assertz(djest(1,X)),assertz(djest(2,X)).
pamietaj2(X,Y) :- assertz(djest(X,Y)).

wyczysc_fakty :-
	retractall(djest(_)),
	retractall(dnie_jest(_)),
	retractall(djest(_,_)).

















