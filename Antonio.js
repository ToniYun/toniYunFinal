//button programming lets the nav bar scroll smoothly
navbarFunction = obj => {
    if (obj.id == "Portfolio") {
        document.getElementById("portfolio").scrollIntoView({ behavior: "smooth" });
    }
    else
        if (obj.id == "Project1") {
            document.getElementById("project").scrollIntoView({ behavior: "smooth" });
        }
        else
            if (obj.id == "Project2") {
                document.getElementById("project2").scrollIntoView({ behavior: "smooth" });
            }
            else
                if (obj.id == "Games") {
                    document.getElementById("games").scrollIntoView({ behavior: "smooth" });
                }
                else
                    if (obj.id == "Games2") {
                        document.getElementById("games2").scrollIntoView({ behavior: "smooth" });
                    }
                    else
                        if (obj.id == "Github") {
                            document.getElementById("github").scrollIntoView({ behavior: "smooth" });
                        }
                        else
                            if (obj.id == "backToTop") {
                                document.getElementsByClassName("offset")[0].scrollIntoView({ behavior: "smooth" });
                            }
                            else {
                                document.getElementsByClassName("offset")[0].scrollIntoView({ behavior: "smooth" });
                            }
}


function offSet() {
    for (var i = 0; i < document.getElementsByClassName("offset").length; i++) {
        document.getElementsByClassName("offset")[i].style.height = document.getElementsByClassName("navbar")[0].getBoundingClientRect().height + "px";
    }
}
function offSet2() {
    for (var i = 0; i < document.getElementsByClassName("offset2").length; i++) {
        document.getElementsByClassName("offset2")[i].style.height = document.getElementsByClassName("navbar")[0].getBoundingClientRect().height / 2 + "px";
    }
}

// Beginning of typing
const TYPING_SPEED = 50;
let $targetList;
//function activates when the page is first open
const init = () => {
    $targetList = document.querySelectorAll('[data-js="typing"]');
    setup();
    run();
}
//sets up the text to start typing
const setup = () => {
    for (const $dom of $targetList) {
        const textList = $dom.innerText.split('');
        let html = '';
        for (const char of textList) {
            html += `<span>${char}</span>`;
        }
        $dom.innerHTML = html;
    }
}
//adds a delay and gradually increeses as it finds more items to add
const run = () => {
    let delay = 0;
    for (let i = 0; i < $targetList.length; i++) {
        const $target = $targetList[i];
        const $chars = $target.querySelectorAll('span');
        for (let l = 0; l < $chars.length; l++) {
            const $char = $chars[l];
            delay += TYPING_SPEED;
            const animate = () => {
                $char.style.display = 'inline-block';
            }
            setTimeout(animate, delay);
            if ($chars.length - 1 <= l) {
                delay += TYPING_SPEED * 4;
                setTimeout(() => $target.style.display = 'block', delay);
            }
        }
    }
}
document.addEventListener('DOMContentLoaded', init, false);
