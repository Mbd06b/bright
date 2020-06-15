import { Component, OnInit, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-letter-scroll',
  templateUrl: './letter-scroll.component.html',
  styleUrls: ['./letter-scroll.component.scss']
})
export class LetterScrollComponent implements OnInit {

  currentWordIndex = 0;

  ideaActions = [
    { color: 'wisteria', word: 'fix', letters: [], opacity: 1 },
    { color: 'belize', word: 'improve', letters: [], opacity: 0 },
    { color: 'pomegranate', word: 'create', letters: [], opacity: 0 },
    { color: 'green', word: 'solve', letters: [], opacity: 0 },
    { color: 'midnight', word: 'enhance', letters: [], opacity: 0 }
  ];

  constructor(  ) {   }


  ngOnInit(): void {
    this.ideaActions.forEach( (action) => {
      const letterArray = action.word.split('');
      letterArray.forEach( ( letter ) => {
          action.letters.push({ value: letter, state: 'out'});
        });
    });
    setInterval( () => {
      this.changeWord();
    }, 4000 );
    this.changeWord();
  }

  changeWord() {

    // if this is the last action word
    let nextActionIndex = this.currentWordIndex === this.ideaActions.length - 1
                           // next word will become the initial aciton in the array
                          ? 0
                          // otherwise it's the next action word
                          : this.currentWordIndex + 1;

    for (let i = 0; i < this.ideaActions[this.currentWordIndex].letters.length; i++) {
      this.animateLetterOut(this.currentWordIndex, i);
      this.ideaActions[this.currentWordIndex].opacity = 0;
    }

    for (let i = 0; i < this.ideaActions[nextActionIndex].letters.length; i++) {
      this.ideaActions[nextActionIndex].letters[i].state = 'behind';
      this.ideaActions[nextActionIndex].opacity = 1;
      this.animateLetterIn(nextActionIndex, i);
    }
    // if end, reset loop
    this.currentWordIndex = (this.currentWordIndex === this.ideaActions.length - 1) ? 0 : this.currentWordIndex + 1;
  }

 animateLetterOut(currentWordIndex, i) {
    setTimeout( () => {
      this.ideaActions[currentWordIndex].letters[i].state = 'out';
    }, i * 80);
  }

 animateLetterIn(nextActionIndex, i) {
    setTimeout( () => {
      this.ideaActions[nextActionIndex].letters[i].state = 'in';
    }, 340 + (i * 80));
  }

}
