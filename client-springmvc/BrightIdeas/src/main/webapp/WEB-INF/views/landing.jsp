<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<tags:template>
	<jsp:attribute name="head">  
		
		<style>
				
		@import url(https://fonts.googleapis.com/css?family=Open+Sans:600);
		
		   .navbar {
		      margin-bottom: 0;
		      border-radius: 0;
		    }
		    
		    /* Add a gray background color and some padding to the footer */
		    footer {
		      background-color: #f2f2f2;
		      padding: 25px;
		    }
		
		.tagline-text {
		  font-family: 'Open Sans', sans-serif;
		}
		
		p {
		  display: inline-block;
		  vertical-align: top;
		  margin: 0;
		}
		
		.word-scroll {
		  position: absolute;
		  width: 220px;
		  opacity: 0;
		}
		
		.letter {
		  display: inline-block;
		  position: relative;
		  float: left;
		  transform: translateZ(25px);
		  transform-origin: 50% 50% 25px;
		}
		
		.letter.out {
		  transform: rotateX(90deg);
		  transition: transform 0.32s cubic-bezier(0.55, 0.055, 0.675, 0.19);
		}
		
		.letter.behind {
		  transform: rotateX(-90deg);
		}
		
		.letter.in {
		  transform: rotateX(0deg);
		  transition: transform 0.38s cubic-bezier(0.175, 0.885, 0.32, 1.275);
		}
		
		.wisteria {
		  color: #8e44ad;
		}
		
		.belize {
		  color: #2980b9;
		}
		
		.pomegranate {
		  color: #c0392b;
		}
		
		.green {
		  color: #16a085;
		}
		
		.midnight {
		  color: #2c3e50;
		}
		</style>
		
		
  	</jsp:attribute>  
	<jsp:body>
	
	<tags:navigation /> 
	
	
	
	
	<div class="jumbotron">
	  <div class="container text-center">
	    <h1>Bright Ideas</h1>      
	    
	  </div>
	</div>
	  
	<div class="container-fluid bg-3 text-center">    
	  <div class="tagline-text h3">
		  <p>What will we</p>
		  <p>
		    <span class="word-scroll wisteria">fix?</span>
		    <span class="word-scroll belize">improve?</span>
		    <span class="word-scroll pomegranate">create?</span>
		    <span class="word-scroll green">solve?</span>
		    <span class="word-scroll midnight">enhance?</span>
		  </p>
	  </div><br>
	  <div class="row">
	    <div class="col-sm-3">
	      <p>Live Plants for the breakroom</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	    <div class="col-sm-3"> 
	      <p>Fix an Outlet</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	    <div class="col-sm-3"> 
	      <p>Add Banking Services to USPS</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	    <div class="col-sm-3">
	      <p>Build an Opensource Skills Database App</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	  </div>
	</div><br>
	
	<div class="container-fluid bg-3 text-center">    
	  <div class="row">
	    <div class="col-sm-3">
	      <p>Recreate the Titanic in Unreal 4</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	    <div class="col-sm-3"> 
	      <p>Install a Local WiFi Network</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	    <div class="col-sm-3"> 
	      <p>Build a Street Sign</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	    <div class="col-sm-3">
	      <p>Host a Class on Technology</p>
	      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
	    </div>
	  </div>
	</div><br><br>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
<script type="text/javascript">
		
	    
		var words = document.getElementsByClassName('word-scroll');
		var wordArray = [];
		var currentWord = 0;

		words[currentWord].style.opacity = 1;
		for (var i = 0; i < words.length; i++) {
		  splitLetters(words[i]);
		}

		function changeWord() {
		  var cw = wordArray[currentWord];
		  var nw = currentWord == words.length-1 ? wordArray[0] : wordArray[currentWord+1];
		  for (var i = 0; i < cw.length; i++) {
		    animateLetterOut(cw, i);
		  }
		  
		  for (var i = 0; i < nw.length; i++) {
		    nw[i].className = 'letter behind';
		    nw[0].parentElement.style.opacity = 1;
		    animateLetterIn(nw, i);
		  }
		  
		  currentWord = (currentWord == wordArray.length-1) ? 0 : currentWord+1;
		}

		function animateLetterOut(cw, i) {
		  setTimeout(function() {
				cw[i].className = 'letter out';
		  }, i*80);
		}

		function animateLetterIn(nw, i) {
		  setTimeout(function() {
				nw[i].className = 'letter in';
		  }, 340+(i*80));
		}

		function splitLetters(word) {
		  var content = word.innerHTML;
		  word.innerHTML = '';
		  var letters = [];
		  for (var i = 0; i < content.length; i++) {
		    var letter = document.createElement('span');
		    letter.className = 'letter';
		    letter.innerHTML = content.charAt(i);
		    word.appendChild(letter);
		    letters.push(letter);
		  }
		  
		  wordArray.push(letters);
		}

		changeWord();
		setInterval(changeWord, 4000);

 
		</script>

	</jsp:body>
</tags:template>